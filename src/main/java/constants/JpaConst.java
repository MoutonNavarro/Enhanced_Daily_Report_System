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
	String EMP_COL_ADMIN_FLAG = "admin_flag"; //Administrator flag
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
	String REP_COL_REP_DATE = "report_date"; //Date indicating when the report is
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
	String JPQL_PARM_REPORT = "report";	//Report

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

	//Enhanced
	//Addition report queries
	//Acquire number of clapped the report
//	String Q_REP_CLAP_COUNT = ENTITY_REP + ".countClaps";		//[Temporary]It will may deleted
//	String Q_REP_CLAP_COUNT_DEF = "SELECT COUNT(r) AS c FROM r INNER JOIN claps ON r.id = claps.report_id WHERE r.id = 10";	//[Temporary]It will may deleted

	//Configure table
	String TABLE_CONF = "configurations"; //table name
	//Configure table column
	//Visual setting
	String CONF_COL_ID = "id"; //ID
	String CONF_COL_CREATED_AT = "created_at"; //Date created
	String CONF_COL_UPDATED_AT = "updated_at"; //Date updated
	String CONF_COL_LANG = "language"; //Language
	String CONF_COL_LANG_COUNTRY = "lang_country"; //Language of country
	String CONF_COL_TIMEZONE = "time_zone"; //Time zone e.g: "Asia/Manila"
	String CONF_COL_TIMEZONE_AREA = "time_area"; //Time zone of area e.g: "Manila"
	String CONF_COL_IS_SPRING_TIME = "time_is_spring_time"; //Whether is it spring time
	String CONF_COL_COLOR_THEME = "color_theme"; //Set color theme
	String CONF_COL_DISABLE_JS = "disable_js"; //Turn off JavaScript
	String CONF_COL_DISABLE_FLASH = "disable_flash"; //????

	//User setting
	String CONF_COL_USER_COLOR = "user_color"; //User submitted foreground color
	String CONF_COL_USER_BG = "user_background"; //User submitted background color
	String CONF_COL_IS_USER_COLOR_SPECIAL = "user_is_color_special"; //????

	byte SPRING_TIME = 1;	//Enable spring time
	byte NORMAL_TIME = 0;	//Normal time
	byte UNDEF_TIME = 2;	//Undefined
	boolean JS_DISABLED = true;	//Disabled JavaScript
	boolean JS_ENABLED = false;	//Enabled JavaScript
	boolean FLASH_DISABLED = true;	//????
	boolean FLASH_ENABLED = false;	//????
	boolean USER_COLOR_SPECIAL = true;	//????
	boolean USER_COLOR_NORMAL = false;	//????

	//Clap table
	String TABLE_CLAP = "claps"; //table name
	//Clap table column
	String CLAP_COL_REP = "report_id"; //Relative to the report ID
	String CLAP_COL_EMP = "employee_id"; //Clapped employee ID
	String CLAP_COL_REACT = "reaction"; //Type of reaction
	String CLAP_COL_ID = "id";

	//Entity names
	String ENTITY_CLAP = "claps";	//Employees

	//NamedQuery's name and query
	//Acquire all employee whose clapped that report
	String Q_CLAP_GET_ALL = ENTITY_CLAP + ".getAll";	//name
	String Q_CLAP_GET_ALL_DEF = "SELECT c FROM Clap AS c WHERE c.report_id = :" + JPQL_PARM_REPORT + " ORDER BY c.id DESC";	//query
	//Acquire all number of employees whose clapped that report
	String Q_CLAP_COUNT = ENTITY_CLAP + ".count";
	String Q_CLAP_COUNT_DEF = "SELECT COUNT(c) FROM Clap AS c WHERE c.report_id = :" + JPQL_PARM_REPORT;
	//Acquire all report that specified employee clapped
	String Q_CLAP_GET_BY_EMP = ENTITY_CLAP + ".getByEmployee";
	String Q_CLAP_GET_BY_EMP_DEF = "SELECT c FROM Clap AS c WHERE c.employee_id = :" + JPQL_PARM_EMPLOYEE + " ORDER BY c.id DESC";
	//Acquire all report that specified report and employee
	String Q_CLAP_GET_BY_REP_AND_EMP = ENTITY_CLAP + ".getByReportAndEmployee";
	String Q_CLAP_GET_BY_REP_AND_EMP_DEF = "SELECT c FROM Clap AS c WHERE c.employee_id = :" + JPQL_PARM_EMPLOYEE + " AND c.report_id = :" + JPQL_PARM_REPORT + " ORDER BY c.id DESC";

	int CLAP_REACT_CLAP = 1;	//Clap
	int CLAP_REACT_NONE = 0;	//Nothing



}
