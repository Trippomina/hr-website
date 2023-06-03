package hr.app.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import hr.app.api.common.PathCte;
import hr.app.api.model.in.APIEmployeeIn;
import hr.app.api.model.out.APIEmployeeOut;
import hr.app.api.model.transformer.EmployeeTransformer;
import hr.app.service.EmployeeService;
import hr.app.service.exception.BusinessException;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(PathCte.EMPLOYEE_GET_ALL_PATH)
	public ResponseEntity<List<APIEmployeeOut>> getAllEmployees() {
		try {
			Thread.sleep(1000);
			return ResponseEntity.ok()
					.body(EmployeeTransformer.TransformToOutModelList(employeeService.findAllEmployees()));
		} catch (BusinessException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

	@PostMapping(PathCte.EMPLOYEE_ADD_PATH)
	public ResponseEntity<APIEmployeeOut> addEmployee(@RequestBody APIEmployeeIn in) {
		try {	
			Thread.sleep(1000);
			return ResponseEntity.ok().body(EmployeeTransformer
					.TransformToOutModel(employeeService.addEmployee(EmployeeTransformer.TransformFromInModel(in))));
		} catch (BusinessException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

	@PutMapping(PathCte.EMPLOYEE_UPDATE_PATH)
	public ResponseEntity<APIEmployeeOut> updateEmployee(@PathVariable("id") String id, @RequestBody APIEmployeeIn in) {
		try {
			return ResponseEntity.ok().body(EmployeeTransformer.TransformToOutModel(
					employeeService.updateEmployee(EmployeeTransformer.TransformFromInModel(in), id)));
		} catch (BusinessException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

	@DeleteMapping(PathCte.EMPLOYEE_DELETE_PATH)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok().body(employeeService.deleteEmployee(id));
		} catch (BusinessException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

}
