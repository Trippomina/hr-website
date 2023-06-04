package hr.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.app.business.model.LeaveType;
import hr.app.business.model.repository.LeaveTypeRepo;
import hr.app.service.exception.BusinessException;

@Service
public class LeaveTypeService {
	@Autowired
	LeaveTypeRepo leaveTypeRpo;

	public List<LeaveType> getLeaveTypes() {
		try {
			return leaveTypeRpo.findAll();
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}

	}
}
