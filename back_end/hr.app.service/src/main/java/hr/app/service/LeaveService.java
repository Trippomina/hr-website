package hr.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.app.business.model.Employee;
import hr.app.business.model.Leave;
import hr.app.business.model.LeaveType;
import hr.app.business.model.dto.StatisticsDTO;
import hr.app.business.model.repository.EmployeeRepo;
import hr.app.business.model.repository.LeaveRepo;
import hr.app.service.exception.BusinessException;
import hr.app.service.exception.DataModificationException;
import hr.app.service.exception.ResourceNotFoundException;

@Service
public class LeaveService {
	@Autowired
	LeaveRepo leaveRepo;
	@Autowired
	EmployeeRepo employeeRepo;

	public List<Leave> getLeaves() {
		try {
			return leaveRepo.findAll();
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	public List<Leave> getLeavesByDate(Date fromDate, Date toDate) {
		try {
			return leaveRepo.findByFromToDate(fromDate, toDate);
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	public List<Leave> getLeavesByEmployee(String id) {
		try {
			Optional<Employee> o = employeeRepo.findById(id);
			if (o.isPresent()) {
				return leaveRepo.findByEmployeeId(id);
			} else {
				throw new ResourceNotFoundException("Employee does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	public List<Leave> getLeavesByEmployeeAndFromToDate(String id, Date dateFrom, Date dateTo) {
		try {
			Optional<Employee> o = employeeRepo.findById(id);
			if (o.isPresent()) {
				return leaveRepo.findByEmployeeIdAndFromToDate(id, dateFrom, dateTo);
			} else {
				throw new ResourceNotFoundException("Employee does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	public List<StatisticsDTO> getLeavesStatistics() {
		try {
			return leaveRepo.findLeavesStatistics();
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public Leave addLeave(Leave l, String employeeId, String leaveType) {
		try {
			l.setLeaveId(UUID.randomUUID().toString());
			Optional<Employee> o = employeeRepo.findById(employeeId);
			if (o.isPresent()) {
				l.setEmployee(o.get());
				// Lazy fetching
				LeaveType lt = new LeaveType();
				lt.setLeaveTypeId(leaveType);
				l.setLeaveType(lt);
				Leave res = leaveRepo.save(l);
				if (res != null) {
					return res;
				} else {
					throw new DataModificationException("Failed to add leave request.");
				}
			} else {
				throw new DataModificationException("employee does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public Leave updateLeave(Leave l, String id, String leaveType) {
		try {
			Optional<Leave> o = leaveRepo.findById(id);
			if (o.isPresent()) {
				l.setLeaveId(id);
				l.setEmployee(o.get().getEmployee());
				// Lazy fetching
				LeaveType lt = new LeaveType();
				lt.setLeaveTypeId(leaveType);
				l.setLeaveType(lt);
				Leave res = leaveRepo.save(l);
				if (res != null) {
					return res;
				} else {
					throw new DataModificationException("Failed to update leave.");
				}
			} else {
				throw new ResourceNotFoundException("Leave request [" + id + "] does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public String deleteLeave(String id) {
		try {
			Optional<Leave> o = leaveRepo.findById(id);
			if (o.isPresent()) {
				Leave e = o.get();
				leaveRepo.delete(e);
				return "Leave record has been deleted successfully.";
			} else {
				throw new ResourceNotFoundException("Leave does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

}
