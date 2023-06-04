package hr.app.api.common;

public class PathCte {

	private static final String MAIN_PATH = "/hr";
	// Employee Controller Paths
	public static final String EMPLOYEE_PATH = MAIN_PATH + "/employee";
	public static final String EMPLOYEE_GET_ALL_PATH = EMPLOYEE_PATH + "/all";
	public static final String EMPLOYEE_ADD_PATH = EMPLOYEE_PATH + "/add";
	public static final String EMPLOYEE_UPDATE_PATH = EMPLOYEE_PATH + "/update/{id}";
	public static final String EMPLOYEE_DELETE_PATH = EMPLOYEE_PATH + "/delete/{id}";
	// LeaveType Controller Paths
	public static final String LEAVE_TYPE_PATH = MAIN_PATH + "/leave-type";
	// Leave Controller Paths
	public static final String LEAVE_PATH = MAIN_PATH + "/leave";
	public static final String LEAVE_GET_ALL_PATH = LEAVE_PATH + "/all";
	public static final String LEAVE_GET_ALL_FILTER_DATE_PATH = LEAVE_PATH + "/all/filter";
	public static final String LEAVE_GET_BY_EMPLOYEE_PATH = LEAVE_PATH + "/{employeeId}";
	public static final String LEAVE_GET_BY_EMPLOYEE_FILTER_DATE_PATH = LEAVE_PATH + "/{employeeId}/filter";
	public static final String LEAVE_ADD_PATH = LEAVE_PATH + "/add";
	public static final String LEAVE_UPDATE_PATH = LEAVE_PATH + "/update/{id}";
	public static final String LEAVE_DELETE_PATH = LEAVE_PATH + "/delete/{id}";
	public static final String LEAVE_GET_STATISTICS_PATH = LEAVE_PATH + "/statistics";

}
