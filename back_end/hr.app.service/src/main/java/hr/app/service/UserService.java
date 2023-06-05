package hr.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.app.business.model.Employee;
import hr.app.business.model.repository.EmployeeRepo;
import hr.app.service.exception.AuthenticationException;
import hr.app.service.exception.BusinessException;

@Service
public class UserService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee login(String email) {
		try {
			Optional<Employee> o = employeeRepo.findByEmail(email);
			if (o.isPresent()) {
				return o.get();
			} else {
				throw new AuthenticationException("User not found.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());

		}
	}
}
