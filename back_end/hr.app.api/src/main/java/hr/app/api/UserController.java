package hr.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import hr.app.api.common.PathCte;
import hr.app.api.model.out.APIEmployeeOut;
import hr.app.api.model.transformer.EmployeeTransformer;
import hr.app.service.UserService;
import hr.app.service.exception.BusinessException;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping(PathCte.USER_LOGIN_PATH)
	public ResponseEntity<APIEmployeeOut> login(@PathVariable("email") String email) {
		try {
			Thread.sleep(1000);
			return ResponseEntity.ok().body(EmployeeTransformer.TransformToOutModel(userService.login(email)));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}
}
