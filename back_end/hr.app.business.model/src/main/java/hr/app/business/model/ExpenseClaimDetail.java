package hr.app.business.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the expense_claim_detail database table.
 * 
 */

//@SqlResultSetMapping(name = "StatisticsDTOMapping", classes = @ConstructorResult(targetClass = StatisticsDTO.class, columns = {
//		@ColumnResult(name = "type", type = String.class), @ColumnResult(name = "typeTotal", type = Long.class) }))

@NamedNativeQuery(name = "ExpenseClaimDetail.findExpenseClaimsStatistics", query = "SELECT ec_type as type, COUNT(total) AS typeTotal\r\n"
		+ "FROM expense_claim_detail\r\n" + "GROUP BY ec_type;", resultSetMapping = "StatisticsDTOMapping")

@Entity
@Table(name = "expense_claim_detail")
@NamedQuery(name = "ExpenseClaimDetail.findAll", query = "SELECT e FROM ExpenseClaimDetail e")
public class ExpenseClaimDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ec_dtl_id")
	private String ecDtlId;

	private String description;

	@Column(name = "ec_type")
	private String ecType;

	@Temporal(TemporalType.DATE)
	@Column(name = "submission_date")
	private Date submissionDate;

	private BigDecimal total;

	// bi-directional many-to-one association to ExpenseClaim
//	@Transient
//	private String ecId;
//	
//	public String getEcId() {
//		return ecId;
//	}
//
//	public void setEcId(String ecId) {
//		this.ecId = ecId;
//	}
	@ManyToOne()
	@JoinColumn(name = "ec_id")
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

	public String getEcType() {
		return this.ecType;
	}

	public void setEcType(String ecType) {
		this.ecType = ecType;
	}

	public Date getSubmissionDate() {
		return this.submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
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