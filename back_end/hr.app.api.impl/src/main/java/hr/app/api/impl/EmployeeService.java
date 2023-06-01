package hr.app.api.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.app.business.model.Employee;
import hr.app.business.model.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Transactional
	public List<Employee> findAllEmployees() {
		List<Employee> res = employeeRepo.findAll();
		return res;
	}
}
