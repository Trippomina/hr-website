package hr.app.service;

import java.util.ArrayList;
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
import hr.app.business.model.repository.ExpenseClaimDetailRepo;
import hr.app.business.model.repository.ExpenseClaimRepo;
import hr.app.service.exception.BusinessException;
import hr.app.service.exception.DataModificationException;
import hr.app.service.exception.ResourceNotFoundException;

//This Service uses ExpenseClaimDetailService
@Service
public class ExpenseClaimService {
	@Autowired
	private ExpenseClaimDetailService ecdService;

	@Autowired
	private ExpenseClaimRepo ecRepo;

	@Autowired
	private ExpenseClaimDetailRepo ecdRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

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
	public ExpenseClaim addExpenseClaim(ExpenseClaim ec, String employeeId) {
		try {
			Optional<Employee> o = employeeRepo.findById(employeeId);
			if (o.isPresent()) {
				ec.setEcId(UUID.randomUUID().toString());
				ec.setEmployee(o.get());
				ExpenseClaim res = ecRepo.save(ec);
				List<ExpenseClaimDetail> details = new ArrayList<>();
				for (ExpenseClaimDetail ecd : ec.getExpenseClaimDetails()) {
					details.add(ecdService.addExpenseClaimDetail(ecd, res.getEcId()));
				}
				res.setExpenseClaimDetails(details);
				res = ecRepo.save(res);
				return res;
			} else {
				throw new ResourceNotFoundException("Employee does not exist.");
			}

		} catch (

		Exception ex) {
			throw new BusinessException(ex.getMessage());

		}
	}

	@Transactional
	public ExpenseClaim updateExpenseClaim(ExpenseClaim ec, String id) {
		try {
			Optional<ExpenseClaim> o = ecRepo.findById(id);
			if (o.isPresent()) {
				ec.setEcId(id);
				ec.setEmployee(o.get().getEmployee());
				ecdRepo.deleteAll(o.get().getExpenseClaimDetails());
				System.out.println("deleted");
				for (ExpenseClaimDetail ecd : ec.getExpenseClaimDetails()) {
					ec.getExpenseClaimDetails().add(ecdService.addExpenseClaimDetail(ecd, id));
					System.out.println("added");
				}
				ExpenseClaim res = ecRepo.save(ec);
				System.out.println("saved");
				if (res != null) {
					return res;
				} else {
					throw new DataModificationException("Failed to update expense claim.");
				}
			} else {
				throw new ResourceNotFoundException("Expense Claim [" + id + "] does not exist.");
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
				ecRepo.delete(o.get());
				return "Expense claim has been deleted successfully.";
			} else {
				throw new ResourceNotFoundException("Expense claim does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}
}
