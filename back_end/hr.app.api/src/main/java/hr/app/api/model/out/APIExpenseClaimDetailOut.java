package hr.app.api.model.out;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import hr.app.api.model.APIExpenseClaimDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({ "id", "ec_type", "description", "total", "submission_date" })
public class APIExpenseClaimDetailOut extends APIExpenseClaimDetail {

}
