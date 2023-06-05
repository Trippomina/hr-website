package hr.app.api.model.out;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import hr.app.api.model.APIExpenseClaim;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "id", "employee_name", "description", "total", "submission_date", "status", "details" })
public class APIExpenseClaimOut extends APIExpenseClaim {
	private String id;
	private String employee_name;
	private List<APIExpenseClaimDetailOut> details;
}
