package constants;

/**
 * Interface that defines relative to DB's item value
 */
public interface JpaConst {
	//persistence-unit name
	String PERSISTENCE_UNIT_NAME = "daily_report_system";

	//Max number of acquire data
	int ROW_PER_PAGE = 20; //Number of record that display by one page

	//Employee table
	String TABLE_EMP = "employees"; //table name
	//Employee table column
	String EMP_COL_ID = "id"; //ID
	String EMP_COL_CODE = "code"; //Employee code
	String EMP_COL_NAME = "name"; //Employee name
	String EMP_COL_PASS = "password"; //Password
	String EMP_COL_ADMIN_FLAG = "admin-flag"; //Administrator flag
	String EMP_COL_CREATED_AT = "created_at"; //Date created
	String EMP_COL_UPDATED_AT = "updated_at"; //Date updated
	String EMP_COL_DELETE_FLAG = "delete_flag"; //Delete flag

	int ROLE_ADMIN = 1;	//Administrator right on(Administrator)
	int ROLE_GENERAL = 0;	//Administrator right off (General user)
	int EMP_DEL_TRUE = 1;	//Delete flag on(Deleted)
	int EMP_DEL_FALSE = 0;	//Delete flag off (Active)

	//Report table
	String TABLE_REP = "reports";	//table name
	//Report table column
	String REP_COL_ID = "id";	//ID
	String REP_COL_EMP = "employee_id";	//Employee's ID who created the report
	String REP_COL_REP_DATE = "report-date"; //Date indicating when the report is
	String REP_COL_TITLE = "title";	//The report's title
	String REP_COL_CONTENT = "content"; //content of the report
	String REP_COL_CREATED_AT = "created_at";	//Date created
	String REP_COL_UPDATED_AT = "updated_at";	//Date updated

	//Entity names
	String ENTITY_EMP = "employee";	//Employees
	String ENTITY_REP = "report";	//reports

	//Parameter in JPQL
	String JPQL_PARM_CODE = "code";	//Employee code
	String JPQL_PARM_PASSWORD = "password";	//Password
	String JPQL_PARM_EMPLOYEE = "employee";	//Employee

	//NamedQuery's name and query
	//Acquire all employee with reverse order of ID
	String Q_EMP_GET_ALL = ENTITY_EMP + ".getAll";	//name
	String Q_EMP_GET_ALL_DEF = "SELECT e FROM Employee AS e ORDER BY e.id DESC";	//query
	//Acquire all number of employees
	String Q_EMP_COUNT = ENTITY_EMP + ".count";
	String Q_EMP_COUNT_DEF = "SELECT COUNT(e) FROM Employee AS e";
	//Acquire not deleted employee with employee's code and hashed password as condition
	String Q_EMP_GET_BY_CODE_AND_PASS = ENTITY_EMP + ".getByCodeAndPass";
	String Q_EMP_GET_BY_CODE_AND_PASS_DEF = "SELECT e FROM Employee AS e WHERE e.deleteFlag = 0 AND e.code = :" + JPQL_PARM_CODE + " AND e.password = :" + JPQL_PARM_PASSWORD;
	//Acquire number of employee that has pointed employee code
	String Q_EMP_COUNT_REGISTERED_BY_CODE = ENTITY_EMP + ".countRegisterByCode";
	String Q_EMP_COUNT_REGISTERED_BY_CODE_DEF = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :" + JPQL_PARM_CODE;
	//Acquire all reports with reverse order by ID
	String Q_REP_GET_ALL = ENTITY_REP + ".getAll";
	String Q_REP_GET_ALL_DEF = "SELECT r FROM Report AS r ORDER BY r.id DESC";
	//Acquire all number of reports
	String Q_REP_COUNT = ENTITY_REP + ".count";
	String Q_REP_COUNT_DEF = "SELECT COUNT(r) FROM Report AS r";
	//Acquire all reports with reverse order by ID that pointed employee created.
	String Q_REP_GET_ALL_MINE = ENTITY_REP + ".getAllMine";
	String Q_REP_GET_ALL_MINE_DEF = "SELECT r FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY r.id DESC";
	//Acquire all number of reports that has created by pointed employee.
	String Q_REP_COUNT_ALL_MINE = ENTITY_REP + ".countAllMine";
	String Q_REP_COUNT_ALL_MINE_DEF = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE;
}
