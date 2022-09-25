package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.EmployeeView;
import constants.MessageConst;
import services.EmployeeService;

/**
 * Class that validates value set at Employee instance
 */
public class EmployeeValidator {

	/**
	 * Do validation about each items of Employee instance
	 * @param service Caller Service class instance
	 * @param ev EmployeeView instance
	 * @param codeDuplicateCheckFlag Whether do duplicate check to employee code (check: true  no check: false)
	 * @param passwordCheckFlag Whether do input check to password (check: true  no check: false)
	 * @return Error's list
	 */
	public static List<String> validate(
			EmployeeService service, EmployeeView ev, Boolean codeDuplicateCheckFlag, Boolean passwordCheckFlag){
		List<String> errors = new ArrayList<>();

		//Check employee code
		String codeError = validateCode(service, ev.getCode(), codeDuplicateCheckFlag);
		if (!codeError.equals("")) {
			errors.add(codeError);
		}

		//Check name
		String nameError = validateName(ev.getName());
		if (!nameError.equals("")) {
			errors.add(nameError);
		}

		//Check password
		String passError = validatePassword(ev.getPassword(), passwordCheckFlag);
		if (!passError.equals("")) {
			errors.add(passError);
		}

		return errors;
	}

	/**
	 * Check input of the employee code and return error message
	 * @param service EmployeeService's instance
	 * @param code Employee code
	 * @param codeDuplicateCheckFlag Whether do duplicate check to employee code (check: true  no check: false)
	 * @return Error message
	 */
	private static String validateCode(EmployeeService service, String code, Boolean codeDuplicateCheckFlag) {

		//If no input value then returns an error message
		if (code == null || code.equals("")) {
			return MessageConst.E_NOEMP_CODE.getMessage();
		}

		if (codeDuplicateCheckFlag) {
			//Duplicate check to employee code

			long employeesCount = isDuplicateEmployee(service, code);

			//If the employee code has been already registered then returns an error message
			if (employeesCount > 0) {
				return MessageConst.E_EMP_CODE_EXIST.getMessage();
			}
		}

		//No errors then returns empty string
		return "";
	}

	/**
	 * @param service EmployeeService's instance
	 * @param code Employee code
	 * @return Number of same employee code's data registered at employee table
	 */
	private static long isDuplicateEmployee(EmployeeService service, String code) {

		long employeesCount = service.countByCode(code);
		return employeesCount;
	}

	/**
	 * Check input value at name and if not input value then returns an error message
	 * @param name Name
	 * @return Error message
	 */
	private static String validateName(String name) {
		if (name == null || name.equals("")) {
			return MessageConst.E_NONAME.getMessage();
		}

		//If there is input value then returns empty string
		return "";
	}

	/**
	 * Check input password and returns error message
	 * @param password Password
	 * @param passwordCheckFlag Whether password's input check (check: true  no check: false)
	 * @return Error message
	 */
	private static String validatePassword(String password, Boolean passwordCheckFlag) {
		//Do input check and if there isn't input value then returns an error message
		if (passwordCheckFlag && (password == null || password.equals(""))) {
			return MessageConst.E_NOPASSWORD.getMessage();
		}

		//No errors occurred then return empty string
		return "";
	}

}
