package hr.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.app.business.model.Employee;
import hr.app.business.model.repository.EmployeeRepo;
import hr.app.service.exception.BusinessException;
import hr.app.service.exception.DataModificationException;
import hr.app.service.exception.ResourceNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Transactional
	public List<Employee> findAllEmployees() {
		try {
			return employeeRepo.findAll();
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public Employee addEmployee(Employee e) {
		try {
			e.setEmployeeId(UUID.randomUUID().toString());
			if (employeeRepo.save(e) != null) {
				return e;
			} else {
				throw new DataModificationException("Failed to add employee.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public Employee updateEmployee(Employee e, String id) {
		try {
			Optional<Employee> o = employeeRepo.findById(id);
			if (o.isPresent()) {
				e.setEmployeeId(id);
				if (employeeRepo.save(e) != null) {
					return e;
				} else {
					throw new DataModificationException("Failed to update employee.");
				}
			} else {
				throw new ResourceNotFoundException("Employee does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public String deleteEmployee(String id) {
		try {
			Optional<Employee> o = employeeRepo.findById(id);
			if (o.isPresent()) {
				Employee e = o.get();
				employeeRepo.delete(e);
				return "Employee '" + e.getFullName() + "' has been deleted successfully.";
			} else {
				throw new ResourceNotFoundException("Employee does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}
}
