package hr.app.api.model.out;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import hr.app.api.model.APIEmployee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({ "id", "full_name", "department", "email", "address" })
public class APIEmployeeOut extends APIEmployee {
	private String id;
}
