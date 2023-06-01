package hr.app.business.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the expense_claim_type database table.
 * 
 */
@Entity
@Table(name="expense_claim_type")
@NamedQuery(name="ExpenseClaimType.findAll", query="SELECT e FROM ExpenseClaimType e")
public class ExpenseClaimType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ec_type_id")
	private String ecTypeId;

	@Column(name="ec_type_name")
	private String ecTypeName;

	//bi-directional many-to-one association to ExpenseClaimDetail
	@OneToMany(mappedBy="expenseClaimType")
	private List<ExpenseClaimDetail> expenseClaimDetails;

	public ExpenseClaimType() {
	}

	public String getEcTypeId() {
		return this.ecTypeId;
	}

	public void setEcTypeId(String ecTypeId) {
		this.ecTypeId = ecTypeId;
	}

	public String getEcTypeName() {
		return this.ecTypeName;
	}

	public void setEcTypeName(String ecTypeName) {
		this.ecTypeName = ecTypeName;
	}

	public List<ExpenseClaimDetail> getExpenseClaimDetails() {
		return this.expenseClaimDetails;
	}

	public void setExpenseClaimDetails(List<ExpenseClaimDetail> expenseClaimDetails) {
		this.expenseClaimDetails = expenseClaimDetails;
	}

	public ExpenseClaimDetail addExpenseClaimDetail(ExpenseClaimDetail expenseClaimDetail) {
		getExpenseClaimDetails().add(expenseClaimDetail);
		expenseClaimDetail.setExpenseClaimType(this);

		return expenseClaimDetail;
	}

	public ExpenseClaimDetail removeExpenseClaimDetail(ExpenseClaimDetail expenseClaimDetail) {
		getExpenseClaimDetails().remove(expenseClaimDetail);
		expenseClaimDetail.setExpenseClaimType(null);

		return expenseClaimDetail;
	}

}