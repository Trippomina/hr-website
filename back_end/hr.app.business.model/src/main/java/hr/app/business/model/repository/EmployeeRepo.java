package hr.app.business.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hr.app.business.model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, String> {
	public List<Employee> findAll();

	public Optional<Employee> findById(String id);
}
