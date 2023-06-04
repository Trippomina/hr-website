package hr.app.business.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import hr.app.business.model.LeaveType;

@Repository
public interface LeaveTypeRepo extends CrudRepository<LeaveType, String> {
	public List<LeaveType> findAll();
}
