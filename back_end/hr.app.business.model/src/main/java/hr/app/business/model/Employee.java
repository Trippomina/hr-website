package hr.app.business.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employee_id")
	private String employeeId;

	private String address;

	private String department;

	private String email;

	@Column(name = "full_name")
	private String fullName;

	// bi-directional many-to-one association to ExpenseClaim
	@OneToMany(mappedBy = "employee")
	private List<ExpenseClaim> expenseClaims;

	// bi-directional many-to-one association to Leave
	@OneToMany(mappedBy = "employee")
	private List<Leave> leaves;

	public Employee() {
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<ExpenseClaim> getExpenseClaims() {
		return this.expenseClaims;
	}

	public void setExpenseClaims(List<ExpenseClaim> expenseClaims) {
		this.expenseClaims = expenseClaims;
	}

	public ExpenseClaim addExpenseClaim(ExpenseClaim expenseClaim) {
		getExpenseClaims().add(expenseClaim);
		expenseClaim.setEmployee(this);

		return expenseClaim;
	}

	public ExpenseClaim removeExpenseClaim(ExpenseClaim expenseClaim) {
		getExpenseClaims().remove(expenseClaim);
		expenseClaim.setEmployee(null);

		return expenseClaim;
	}

	public List<Leave> getLeaves() {
		return this.leaves;
	}

	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}

	public Leave addLeave(Leave leave) {
		getLeaves().add(leave);
		leave.setEmployee(this);

		return leave;
	}

	public Leave removeLeave(Leave leave) {
		getLeaves().remove(leave);
		leave.setEmployee(null);

		return leave;
	}

}