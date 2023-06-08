package hr.app.api.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIExpenseClaimDetail {
	private String id;
	private Date submission_date;
	private String ec_type;
	private String description;
	private BigDecimal total;
}
