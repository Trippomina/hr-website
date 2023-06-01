package hr.app.api.model;

import lombok.AllArgsConstructor;	
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class APIEmployee {
	private String fullName;
	private String department;
	private String email;
	private String address;
}
