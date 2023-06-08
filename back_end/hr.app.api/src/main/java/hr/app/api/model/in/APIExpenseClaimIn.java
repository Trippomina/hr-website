package hr.app.api.model.in;

import java.util.List;

import hr.app.api.model.APIExpenseClaim;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIExpenseClaimIn extends APIExpenseClaim {
	private List<APIExpenseClaimDetailIn> details;
}
