package hr.app.api.model.out;

import hr.app.api.model.APIEmployee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class APIEmployeeOut extends APIEmployee{
	private String id;
}
