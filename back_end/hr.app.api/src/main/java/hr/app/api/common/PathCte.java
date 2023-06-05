package hr.app.api.common;

public class PathCte {

	private static final String MAIN_PATH = "/hr";

	// User Controller Paths
	public static final String USER_LOGIN_PATH = MAIN_PATH + "/login/{email}";
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
	public static final String LEAVE_ADD_PATH = LEAVE_PATH + "/{employeeId}/{leaveType}/add";
	public static final String LEAVE_UPDATE_PATH = LEAVE_PATH + "/update/{id}/{leaveType}";
	public static final String LEAVE_DELETE_PATH = LEAVE_PATH + "/delete/{id}";
	public static final String LEAVE_GET_STATISTICS_PATH = LEAVE_PATH + "/statistics";
	// ExpenseClaim Controller Paths
	public static final String EXPENSE_CLAIM_PATH = MAIN_PATH + "/expense-claim";
	public static final String EXPENSE_CLAIM_GET_ALL_PATH = EXPENSE_CLAIM_PATH + "/all";
	public static final String EXPENSE_CLAIM_GET_BY_EMPLOYEE_PATH = EXPENSE_CLAIM_PATH + "/{employeeId}";
	public static final String EXPENSE_CLAIM_ADD_PATH = EXPENSE_CLAIM_PATH + "/{employeeId}/add";
	public static final String EXPENSE_CLAIM_UPDATE_PATH = EXPENSE_CLAIM_PATH + "/update/{id}";
	public static final String EXPENSE_CLAIM_DELETE_PATH = EXPENSE_CLAIM_PATH + "/delete/{id}";
	// ExpenseClaimDetail Controller Paths
	public static final String EXPENSE_CLAIM_DETAIL_PATH = MAIN_PATH + "/expense-claim-detail";
	public static final String EXPENSE_CLAIM_DETAIL_ADD_PATH = EXPENSE_CLAIM_DETAIL_PATH + "/{ecId}/add";
	public static final String EXPENSE_CLAIM_DETAIL_UPDATE_PATH = EXPENSE_CLAIM_DETAIL_PATH + "/update/{id}";
	public static final String EXPENSE_CLAIM_DETAIL_DELETE_PATH = EXPENSE_CLAIM_DETAIL_PATH + "/delete/{id}";
	public static final String EXPENSE_CLAIM_DETAIL_GET_STATISTICS_PATH = EXPENSE_CLAIM_DETAIL_PATH + "/statistics";

}
