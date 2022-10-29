package services;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NoResultException;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import constants.JpaConst;
import constants.LanguageClassConst;
import models.Employee;
import models.validators.EmployeeValidator;
import utils.EncryptUtil;

/**
 * Class that do process relative to operation to employee table
 */
public class EmployeeService extends ServiceBase {

	/**
	 * Acquire data for displays at specified number of page's list screen, and return as EmployeeView's list
	 * @param page Number of page
	 * @return List for displays data
	 */
	public List<EmployeeView> getPerPage(int page){
		List<Employee> employees = em.createNamedQuery(JpaConst.Q_EMP_GET_ALL, Employee.class)
			.setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
			.setMaxResults(JpaConst.ROW_PER_PAGE)
			.getResultList();
		return EmployeeConverter.toViewList(employees);
	}

	/**
	 * Acquire number of data at employee table and return it
	 * @return Number of data at employee table
	 */
	public long countAll() {
		long empCount = (long)em.createNamedQuery(JpaConst.Q_EMP_COUNT, Long.class)
			.getSingleResult();
		return empCount;
	}

	/**
	 * Return acquired data by employee code and password as EmployeeView instance
	 * @param code employee code
	 * @param plainPass Password string
	 * @param pepper pepper string
	 * @return Acquired data's instance  If couldn't acquire then null
	 */
	public EmployeeView findOne(String code, String plainPass, String pepper) {
		Employee e = null;
		try {
			//Password hashing
			String pass = EncryptUtil.getPasswordEncrypt(plainPass, pepper);

			//Acquire one employee with employee code and hashed password as condition
			e = em.createNamedQuery(JpaConst.Q_EMP_GET_BY_CODE_AND_PASS, Employee.class)
				.setParameter(JpaConst.JPQL_PARM_CODE, code)
				.setParameter(JpaConst.JPQL_PARM_PASSWORD, pass)
				.getSingleResult();
		}catch (NoResultException ex) {
		}

		return EmployeeConverter.toView(e);
	}

	/**
	 * Return acquired data with ID as condition as EmployeeView's instance
	 * @param id
	 * @return Acquired instance
	 */
	public EmployeeView findOne(int id) {
		Employee e = findOneInternal(id);
		return EmployeeConverter.toView(e);
	}

	/**
	 * Acquire number of correspond data with employee code as condition and return it
	 * @param code employee code
	 * @return Number of correspond data
	 */
	public long countByCode(String code) {
		//Acquire number of employee that has specified employee code
		long employees_count = (long)em.createNamedQuery(JpaConst.Q_EMP_COUNT_REGISTERED_BY_CODE, Long.class)
			.setParameter(JpaConst.JPQL_PARM_CODE, code)
			.getSingleResult();
		return employees_count;
	}

	/**
	 * Create one data based on the employee registration details entered from the screen and register it on the employee table
	 * @param ev Employee registration detail entered from the screen
	 * @param pepper pepper string
	 * @param lang For localize based on LanguageClassConst enum object
	 * @return Error list that occurred in validating and registration
	 */
	public List<String> create(EmployeeView ev, String pepper, LanguageClassConst lang){
		//Set password with hashing
		String pass = EncryptUtil.getPasswordEncrypt(ev.getPassword(), pepper);
		ev.setPassword(pass);

		//Date registered and date updated are set current time
		LocalDateTime now = LocalDateTime.now();
		ev.setCreatedAt(now);
		ev.setUpdatedAt(now);

		//Validate to registration content
		List<String> errors = EmployeeValidator.validate(this, ev, true, true, lang);

		//There isn't validation error then register the data
		if (errors.size() == 0) {
			create(ev);
		}

		//Returns errors (No error then empty list)
		return errors;
	}
	/**
	 * Create one data based on the employee update detail entered from the screen and update employee table
	 * @param ev Employee's registration detail entered from the screen
	 * @param pepper pepper string
	 * @param lang For localize based on LanguageClassConst enum object
	 * @return Error list that occurred validating and updating
	 */
	public List<String> update(EmployeeView ev, String pepper, LanguageClassConst lang){
		//Acquire information of registered employee with ID as condition
		EmployeeView savedEmp = findOne(ev.getId());

		boolean validateCode = false;
		if (!savedEmp.getCode().equals(ev.getCode())) {
			//In case update employee code

			//Validate about employee code
			validateCode = true;
			//Set employee code after changes
			savedEmp.setCode(ev.getCode());
		}

		boolean validatePass = false;
		if (ev.getPassword() != null && !ev.getPassword().equals("")) {
			//In case there is input at password

			//Validate about password
			validatePass = true;

			//Set password after changes with hashing
			savedEmp.setPassword(EncryptUtil.getPasswordEncrypt(ev.getPassword(), pepper));
		}

		savedEmp.setName(ev.getName());	//Set name after changes
		savedEmp.setAdminFlag(ev.getAdminFlag());	//Set administrator flag after changes

		//Set current time at date updated
		LocalDateTime today = LocalDateTime.now();
		savedEmp.setUpdatedAt(today);

		//Validate about the update content
		List<String> errors = EmployeeValidator.validate(this, savedEmp, validateCode, validatePass, lang);

		//There isn't validation error then update the data
		if (errors.size() == 0) {
			update(savedEmp);
		}

		//Return errors (no errors then empty list)
		return errors;
	}

	/**
	 * Logical delete employee data with ID as condition
	 * @param id
	 * @return False if the employee has been terminated or not found.
	 */
	public boolean destroy(Integer id) {
		//Acquire registered employee information with ID as condition
		EmployeeView savedEmp = findOne(id);
		if (savedEmp == null || savedEmp.getDeleteFlag() == 1) {
			return false;
		}

		//Set current time at date registered
		LocalDateTime today = LocalDateTime.now();
		savedEmp.setUpdatedAt(today);

		//Raise a logical delete flag
		savedEmp.setDeleteFlag(JpaConst.EMP_DEL_TRUE);

		//Update processing
		update(savedEmp);
		return true;
	}

	/**
	 * Search with employee code and password as condition and then return authentication result depending on whether data can be acquired
	 * @param code Employee code
	 * @param plainPass Password
	 * @param pepper pepper string
	 * @return Returns authentication result (success: true  failure: false)
	 */
	public Boolean validateLogin(String code, String plainPass, String pepper) {

		boolean isValidEmployee = false;
		if (code != null && !code.equals("") && plainPass != null && !plainPass.equals("")) {
			EmployeeView ev = findOne(code, plainPass, pepper);

			if (ev != null && ev.getId() != null) {
				//In case acquired data, then authentication success
				isValidEmployee = true;
			}
		}

		//Return the authentication result
		return isValidEmployee;
	}

	/**
	 * Acquire one data with ID as condition, and return it as Employee's instance
	 * @param id
	 * @return Acquired data's instance
	 */
	private Employee findOneInternal(int id) {
		Employee e = em.find(Employee.class, id);
		return e;
	}

	/**
	 * Register one employee data
	 * @param ev Employee data
	 * @return Registration result (Success: true  failure: false)
	 */
	private void create(EmployeeView ev) {
		em.getTransaction().begin();
		em.persist(EmployeeConverter.toModel(ev));
		em.getTransaction().commit();
	}

	/**
	 * Update employee data
	 * @param ev Registration detail of employee entered from the screen
	 */
	private void update(EmployeeView ev) {
		em.getTransaction().begin();
		Employee e = findOneInternal(ev.getId());
		EmployeeConverter.copyViewToModel(e, ev);
		em.getTransaction().commit();
	}
}
