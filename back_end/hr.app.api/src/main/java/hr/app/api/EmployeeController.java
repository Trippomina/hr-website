package hr.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hr.app.api.impl.EmployeeService;
import hr.app.api.model.out.APIEmployeeOut;
import hr.app.api.model.transformer.EmployeeTransformer;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/hr-management/employee/all")
	public ResponseEntity<List<APIEmployeeOut>> getAllEmployees() {
		try {
			return ResponseEntity.ok()
					.body(EmployeeTransformer.TransformListToOutModels(employeeService.findAllEmployees()));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, e.getMessage());
		}
	}

}
