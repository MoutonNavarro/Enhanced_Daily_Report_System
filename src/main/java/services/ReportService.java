package services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.ReportConverter;
import actions.views.ReportView;
import constants.JpaConst;
import models.Report;
import models.validators.ReportValidator;

/**
 * Class that do process relative to operation of the report table
 */
public class ReportService extends ServiceBase {

	/**
	 * Acquires report data that specified employee created for displays list screen of number of the specified page, and return as ReportView' list
	 * @param employee Employee
	 * @param page Number of page
	 * @return A data list for displays at list screen
	 */
	public List<ReportView> getMinePerPage(EmployeeView employee, int page){
		List<Report> reports = em.createNamedQuery(JpaConst.Q_REP_GET_ALL_MINE, Report.class)
			.setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
			.setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
			.getResultList();
		return ReportConverter.toViewList(reports);
	}

	/**
	 * Acquires the specified employee created the report data and return
	 * @param employee
	 * @return Number of report data
	 */
	public long countAllMine(EmployeeView employee) {

		long count = (long)em.createNamedQuery(JpaConst.Q_REP_COUNT_ALL_MINE, Long.class)
			.setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
			.getSingleResult();

		return count;
	}

	/**
	 * Acquires report data for displays at list screen of number of the specified page, and return it as ReportView
	 * @param page Number of page
	 * @return List of the data for displays list screen
	 */
	public List<ReportView> getAllPerPage(int page){

		List<Report> reports = em.createNamedQuery(JpaConst.Q_REP_GET_ALL, Report.class)
			.setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
			.setMaxResults(JpaConst.ROW_PER_PAGE)
			.getResultList();
		return ReportConverter.toViewList(reports);
	}

	/**
	 * Acquire number of the data of the report table and return it
	 * @return Number of the data
	 */
	public long countAll() {
		long reports_count = (long)em.createNamedQuery(JpaConst.Q_REP_COUNT, Long.class)
			.getSingleResult();
		return reports_count;
	}

	/**
	 * Return acquired data with ID as condition as instance of ReportView
	 * @param ID
	 * @return Acquired instance
	 */
	public ReportView findOne(int id) {
		return ReportConverter.toView(findOneInternal(id));
	}

	/**
	 * Create one data based on input content of the report from screen, and register at the report table
	 * @param rv Registration content of the report
	 * @return List of the errors occurred at validation
	 */
	public List<String> create(ReportView rv){
		List<String> errors = ReportValidator.validate(rv);
		if (errors.size() == 0) {
			LocalDateTime ldt = LocalDateTime.now(ZoneId.of("UTC"));	//Acquire current time as Coordinated Universal Time
			rv.setCreatedAt(ldt);
			rv.setUpdatedAt(ldt);
			createInternal(rv);
		}

		//Returns errors occurred at validation (No errors then empty list)
		return errors;
	}

	/**
	 * Update the report data based on the input content of the report from the screen
	 * @param rv Update content of the report
	 * @return List of the errors occurred at it's validation
	 */
	public List<String> update(ReportView rv){

		//Do validation
		List<String> errors = ReportValidator.validate(rv);

		if (errors.size() == 0) {
			//Set current time at date updated
			LocalDateTime ldt = LocalDateTime.now(ZoneId.of("UTC"));	//Acquire current time as Coordinated Universal Time
			rv.setUpdatedAt(ldt);

			updateInternal(rv);
		}

		//Returns errors occurred at the validation (No errors then empty list)
		return errors;
	}

	/**
	 * Acquires one data with ID as condition
	 * @param ID
	 * @return Instance of acquired data
	 */
	private Report findOneInternal(int id) {
		return em.find(Report.class, id);
	}

	/**
	 * Register one report data
	 * @param rv Report data
	 */
	private void createInternal(ReportView rv) {
		em.getTransaction().begin();
		em.persist(ReportConverter.toModel(rv));
		em.getTransaction().commit();
	}

	/**
	 * Update the report data
	 * @param rv Report data
	 */
	private void updateInternal(ReportView rv) {
		em.getTransaction().begin();
		Report r = findOneInternal(rv.getId());
		ReportConverter.copyViewToModel(r, rv);
		em.getTransaction().commit();
	}
}
