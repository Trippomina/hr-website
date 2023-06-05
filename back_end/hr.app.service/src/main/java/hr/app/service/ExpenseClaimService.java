package hr.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.app.business.model.Employee;
import hr.app.business.model.ExpenseClaim;
import hr.app.business.model.ExpenseClaimDetail;
import hr.app.business.model.repository.EmployeeRepo;
import hr.app.business.model.repository.ExpenseClaimRepo;
import hr.app.service.exception.BusinessException;
import hr.app.service.exception.DataModificationException;
import hr.app.service.exception.ResourceNotFoundException;

//This Service uses ExpenseClaimDetailService
@Service
public class ExpenseClaimService {

	@Autowired
	private ExpenseClaimRepo ecRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ExpenseClaimDetailService ecdService;

	public List<ExpenseClaim> getExpenseClaims() {
		try {
			return ecRepo.findAll();
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	public List<ExpenseClaim> getExpenseClaimsByEmployee(String id) {
		try {
			Optional<Employee> o = employeeRepo.findById(id);
			if (o.isPresent()) {
				return ecRepo.findByEmployeeId(id);
			} else {
				throw new ResourceNotFoundException("Employee does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public ExpenseClaim addExpenseClaim(ExpenseClaim ec) {
		try {
			ec.setEcId(UUID.randomUUID().toString());
			// create Employee object
			Employee employee = new Employee();
			employee.setEmployeeId(ec.getEmployeeId());
			// add object to expense claim
			ec.setEmployee(employee);
			// save
			ExpenseClaim res = ecRepo.save(ec);
			if (res != null) {
				// add details
				List<ExpenseClaimDetail> details = ecdService.addExpenseClaimDetailList(ec.getExpenseClaimDetails(),
						res.getEcId());
				res.setExpenseClaimDetails(details);
				return res;
			} else {
				throw new DataModificationException("Failed to submit expense claim");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public ExpenseClaim updateExpenseClaim(ExpenseClaim ec) {
		try {
			// create Employee object
			Employee employee = new Employee();
			employee.setEmployeeId(ec.getEmployeeId());
			// update object to expense claim
			ec.setEmployee(employee);
			// save
			ExpenseClaim res = ecRepo.save(ec);
			if (res != null) {
				// update details
				List<ExpenseClaimDetail> details = ecdService.updateExpenseClaimDetailList(ec.getExpenseClaimDetails(),
						res.getEcId());
				res.setExpenseClaimDetails(details);
				return res;
			} else {
				throw new DataModificationException("Failed to submit expense claim");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public String deleteExpenseClaim(String id) {
		try {
			Optional<ExpenseClaim> o = ecRepo.findById(id);
			if (o.isPresent()) {
				ExpenseClaim ec = o.get();
				ecRepo.delete(ec);
				return "Expense claim has been deleted successfully.";
			} else {
				throw new ResourceNotFoundException("Expence claim does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}
}
