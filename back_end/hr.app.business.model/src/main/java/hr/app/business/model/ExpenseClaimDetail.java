package hr.app.business.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the expense_claim_detail database table.
 * 
 */
@Entity
@Table(name="expense_claim_detail")
@NamedQuery(name="ExpenseClaimDetail.findAll", query="SELECT e FROM ExpenseClaimDetail e")
public class ExpenseClaimDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ec_dtl_id")
	private String ecDtlId;

	private String description;

	@Column(name="ec_type_id")
	private String ecTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name="submition_date")
	private Date submitionDate;

	private BigDecimal total;

	//bi-directional many-to-one association to ExpenseClaim
	@ManyToOne
	@JoinColumn(name="ec_id")
	private ExpenseClaim expenseClaim;

	public ExpenseClaimDetail() {
	}

	public String getEcDtlId() {
		return this.ecDtlId;
	}

	public void setEcDtlId(String ecDtlId) {
		this.ecDtlId = ecDtlId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEcTypeId() {
		return this.ecTypeId;
	}

	public void setEcTypeId(String ecTypeId) {
		this.ecTypeId = ecTypeId;
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

	public ExpenseClaim getExpenseClaim() {
		return this.expenseClaim;
	}

	public void setExpenseClaim(ExpenseClaim expenseClaim) {
		this.expenseClaim = expenseClaim;
	}

}