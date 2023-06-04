package hr.app.api.model.in;

import hr.app.api.model.APILeave;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APILeaveIn extends APILeave {
	private String employee_id;
	private String leave_type_id;
}
