package hr.app.api.model.out;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import hr.app.api.model.APIExpenseClaimDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({ "id", "submition_date", "ec_type", "description", "total"})
public class APIExpenseClaimDetailOut extends APIExpenseClaimDetail {
	private String id;
}
