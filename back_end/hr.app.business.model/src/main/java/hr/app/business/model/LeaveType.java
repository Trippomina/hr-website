package hr.app.business.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the leave_type database table.
 * 
 */
@Entity
@Table(name="leave_type")
@NamedQuery(name="LeaveType.findAll", query="SELECT l FROM LeaveType l")
public class LeaveType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="leave_type_id")
	private String leaveTypeId;

	@Column(name="leave_type_name")
	private String leaveTypeName;

	//bi-directional many-to-one association to Leave
	@OneToMany(mappedBy="leaveType")
	private List<Leave> leaves;

	public LeaveType() {
	}

	public String getLeaveTypeId() {
		return this.leaveTypeId;
	}

	public void setLeaveTypeId(String leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getLeaveTypeName() {
		return this.leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public List<Leave> getLeaves() {
		return this.leaves;
	}

	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}

	public Leave addLeave(Leave leave) {
		getLeaves().add(leave);
		leave.setLeaveType(this);

		return leave;
	}

	public Leave removeLeave(Leave leave) {
		getLeaves().remove(leave);
		leave.setLeaveType(null);

		return leave;
	}

}