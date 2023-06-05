package hr.app.api.model.in;

import java.util.List;

import hr.app.api.model.APIExpenseClaim;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class APIExpenseClaimIn extends APIExpenseClaim {
	 private String  employee_id;
	 private List<APIExpenseClaimDetailIn> details;
}
