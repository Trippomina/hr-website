package hr.app.api.model.out;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import hr.app.api.model.APILeave;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "id", "employee_id", "leave_type", "date_from", "date_to", "days", "note", })
public class APILeaveOut extends APILeave {
	private String id;
	private String employee_name;
	private String leave_type;
	private int days;
}
