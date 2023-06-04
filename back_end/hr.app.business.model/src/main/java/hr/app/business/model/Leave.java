package hr.app.business.model;

import java.io.Serializable;
import javax.persistence.*;

import hr.app.business.model.dto.StatisticsDTO;

import java.util.Date;


/**
 * The persistent class for the leave database table.
 * 
 */

@SqlResultSetMapping(
	    name = "StatisticsDTOMapping",
	    classes = @ConstructorResult(
	        targetClass = StatisticsDTO.class,
	        columns = {
	            @ColumnResult(name = "type", type = String.class),
	            @ColumnResult(name = "typeTotal", type = Long.class)
	        }
	    )
	)
	@NamedNativeQuery(
	    name = "Leave.findLeavesStatistics",
	    query = "SELECT lt.leave_type_name AS type, COUNT(*) AS typeTotal FROM leave l JOIN leave_type lt ON l.leave_type_id = lt.leave_type_id GROUP BY lt.leave_type_name",
	    resultSetMapping = "StatisticsDTOMapping"
	)
@Entity
@NamedQuery(name="Leave.findAll", query="SELECT l FROM Leave l")
public class Leave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="leave_id")
	private String leaveId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_from")
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="date_to")
	private Date dateTo;

	private Integer days;

	private String note;

	//bi-directional many-to-one association to Employee
	@Transient
	private String employeeId;
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employee;

	//bi-directional many-to-one association to LeaveType
	@Transient 
	private String leaveTypeId;
	
	public String getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(String leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="leave_type_id")
	private LeaveType leaveType;

	public Leave() {
	}

	public String getLeaveId() {
		return this.leaveId;
	}

	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LeaveType getLeaveType() {
		return this.leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

}