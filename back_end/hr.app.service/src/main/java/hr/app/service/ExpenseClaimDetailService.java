package hr.app.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.app.business.model.ExpenseClaim;
import hr.app.business.model.ExpenseClaimDetail;
import hr.app.business.model.repository.ExpenseClaimDetailRepo;
import hr.app.service.exception.BusinessException;
import hr.app.service.exception.DataModificationException;

//This Service is used by  ExpenseClaimService
@Service
public class ExpenseClaimDetailService {
	@Autowired
	private ExpenseClaimDetailRepo ecdRepo;

	@Transactional
	public ExpenseClaimDetail addExpenseClaimDetail(ExpenseClaimDetail ecd) {
		try {
			ecd.setEcDtlId(UUID.randomUUID().toString());
			// create ExpenseClaim object
			ExpenseClaim ec = new ExpenseClaim();
			ec.setEcId(ecd.getEcId());
			// add object to expense claim
			ecd.setExpenseClaim(ec);
			// save
			ExpenseClaimDetail res = ecdRepo.save(ecd);
			if (res != null) {
				return res;
			} else {
				throw new DataModificationException("Failed to add expense claim details");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public ExpenseClaimDetail addExpenseClaimDetail(ExpenseClaimDetail ecd, String ecId) {
		try {
			ecd.setEcDtlId(UUID.randomUUID().toString());
			// create ExpenseClaim object
			ExpenseClaim ec = new ExpenseClaim();
			ec.setEcId(ecId);
			// add object to expense claim
			ecd.setExpenseClaim(ec);
			// save
			ExpenseClaimDetail res = ecdRepo.save(ecd);
			if (res != null) {
				System.out.println("addExpenseClaimDetail(res != null)");
				return res;
			} else {
				throw new DataModificationException("Failed to add expense claim details");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public List<ExpenseClaimDetail> addExpenseClaimDetailList(List<ExpenseClaimDetail> list, String ecId) {
		System.out.println("addExpenseClaimDetailList:"+ecId);
		return list.stream().map(ecd -> addExpenseClaimDetail(ecd, ecId)).collect(Collectors.toList());
	}
	
	@Transactional
	public ExpenseClaimDetail updateExpenseClaimDetail(ExpenseClaimDetail ecd, String ecId) {
		try {
			System.out.println(ecd.getEcDtlId());
			// create ExpenseClaim object
			ExpenseClaim ec = new ExpenseClaim();
			ec.setEcId(ecId);
			// add expenseClaim to expense claim detail
			ecd.setExpenseClaim(ec);
			// save
			ExpenseClaimDetail res = ecdRepo.save(ecd);
			if (res != null) {
				return res;
			} else {
				throw new DataModificationException("Failed to update expense claim details");
			}
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage());
		}
	}

	@Transactional
	public List<ExpenseClaimDetail> updateExpenseClaimDetailList(List<ExpenseClaimDetail> list, String ecId) {
		return list.stream().map(ecd -> updateExpenseClaimDetail(ecd, ecId)).collect(Collectors.toList());
	}
}
