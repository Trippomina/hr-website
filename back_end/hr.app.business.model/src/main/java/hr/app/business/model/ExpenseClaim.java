package hr.app.business.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the expense_claim database table.
 * 
 */
@Entity
@Table(name="expense_claim")
@NamedQuery(name="ExpenseClaim.findAll", query="SELECT e FROM ExpenseClaim e")
public class ExpenseClaim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ec_id")
	private String ecId;

	private String description;

	private String status;

	@Temporal(TemporalType.DATE)
	@Column(name="submition_date")
	private Date submitionDate;

	private BigDecimal total;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	//bi-directional many-to-one association to ExpenseClaimDetail
	@OneToMany(mappedBy="expenseClaim")
	private List<ExpenseClaimDetail> expenseClaimDetails;

	public ExpenseClaim() {
	}

	public String getEcId() {
		return this.ecId;
	}

	public void setEcId(String ecId) {
		this.ecId = ecId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSubmitionDate() {
		return this.submitionDate;
	}

	public void setSubmitionDate(Date submitionDate) {
		this.submitionDate = submitionDate;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<ExpenseClaimDetail> getExpenseClaimDetails() {
		return this.expenseClaimDetails;
	}

	public void setExpenseClaimDetails(List<ExpenseClaimDetail> expenseClaimDetails) {
		this.expenseClaimDetails = expenseClaimDetails;
	}

	public ExpenseClaimDetail addExpenseClaimDetail(ExpenseClaimDetail expenseClaimDetail) {
		getExpenseClaimDetails().add(expenseClaimDetail);
		expenseClaimDetail.setExpenseClaim(this);

		return expenseClaimDetail;
	}

	public ExpenseClaimDetail removeExpenseClaimDetail(ExpenseClaimDetail expenseClaimDetail) {
		getExpenseClaimDetails().remove(expenseClaimDetail);
		expenseClaimDetail.setExpenseClaim(null);

		return expenseClaimDetail;
	}

}