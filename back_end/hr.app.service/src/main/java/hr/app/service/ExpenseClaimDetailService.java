package hr.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.app.business.model.ExpenseClaim;
import hr.app.business.model.ExpenseClaimDetail;
import hr.app.business.model.dto.StatisticsDTO;
import hr.app.business.model.repository.ExpenseClaimDetailRepo;
import hr.app.business.model.repository.ExpenseClaimRepo;
import hr.app.service.exception.BusinessException;
import hr.app.service.exception.DataModificationException;
import hr.app.service.exception.ResourceNotFoundException;

//This Service is used by  ExpenseClaimService
@Service
public class ExpenseClaimDetailService {
	@Autowired
	private ExpenseClaimDetailRepo ecdRepo;

	@Autowired
	private ExpenseClaimRepo ecRepo;

	public List<StatisticsDTO> getExpenseClaimsStatistics() {
		try {
			return ecdRepo.findExpenseClaimsStatistics();
		} catch (Exception ex) {
			throw new BusinessException("Failed to retrieve Expense claims statistics.");
		}
	}

	@Transactional
	public ExpenseClaimDetail addExpenseClaimDetail(ExpenseClaimDetail ecd, String ecId) {
		try {
			Optional<ExpenseClaim> o = ecRepo.findById(ecId);
			if (o.isPresent()) {
				ecd.setEcDtlId(UUID.randomUUID().toString());
				ecd.setExpenseClaim(o.get());
				ExpenseClaimDetail res = ecdRepo.save(ecd);
				if (res != null) {
					return res;
				} else {
					throw new DataModificationException("Failed to add expense claim detail.");
				}
			} else {
				throw new ResourceNotFoundException("Employee does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());

		}
	}

	@Transactional
	public ExpenseClaimDetail updateExpenseClaimDetail(ExpenseClaimDetail ecd, String id) {
		try {
			Optional<ExpenseClaimDetail> o = ecdRepo.findById(id);
			if (o.isPresent()) {
				ecd.setEcDtlId(id);
				ecd.setExpenseClaim(o.get().getExpenseClaim());
				ExpenseClaimDetail res = ecdRepo.save(ecd);
				if (res != null) {
					return res;
				} else {
					throw new DataModificationException("Failed to update expense claim detail.");
				}
			} else {
				throw new ResourceNotFoundException("Employee does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());

		}
	}

	@Transactional
	public String deleteExpenseClaimDetail(String id) {
		try {
			Optional<ExpenseClaimDetail> o = ecdRepo.findById(id);
			if (o.isPresent()) {
				ecdRepo.delete(o.get());
				return "Expense claim detail has been deleted successfully.";
			} else {
				throw new ResourceNotFoundException("Expense claim detail does not exist.");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}
}
