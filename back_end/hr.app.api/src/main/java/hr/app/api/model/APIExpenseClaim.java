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
public class APIExpenseClaim {
	 private Date submission_date;
	 private String description;
	 private String status;
	 private BigDecimal total;
}
