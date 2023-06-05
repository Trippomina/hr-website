package hr.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import hr.app.api.common.PathCte;
import hr.app.api.model.in.APIExpenseClaimIn;
import hr.app.api.model.out.APIExpenseClaimOut;
import hr.app.api.model.transformer.ExpenseClaimTransformer;
import hr.app.business.model.ExpenseClaim;
import hr.app.service.ExpenseClaimService;
import hr.app.service.exception.BusinessException;

@RestController
public class ExpenseClaimController {

	@Autowired
	private ExpenseClaimService ecService;

	@GetMapping(PathCte.EXPENSE_CLAIM_GET_ALL_PATH)
	public ResponseEntity<List<APIExpenseClaimOut>> getAllExpenseClaims() {
		try {
			List<ExpenseClaim> res = ecService.getExpenseClaims();
			return ResponseEntity.ok().body(ExpenseClaimTransformer.TransformToOutModelList(res));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	@GetMapping(PathCte.EXPENSE_CLAIM_GET_BY_EMPLOYEE_PATH)
	public ResponseEntity<List<APIExpenseClaimOut>> getLeavesByEmployee(@PathVariable("employeeId") String employeeId) {
		try {
			List<ExpenseClaim> res = ecService.getExpenseClaimsByEmployee(employeeId);
			return ResponseEntity.ok().body(ExpenseClaimTransformer.TransformToOutModelList(res));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}

	@PostMapping(PathCte.EXPENSE_ADD_CLAIM_PATH)
	public ResponseEntity<APIExpenseClaimOut> addExpenseClaim(@RequestBody APIExpenseClaimIn in) {
		try {
			APIExpenseClaimOut res = ExpenseClaimTransformer
					.TransfromToOutModel(ecService.addExpenseClaim(ExpenseClaimTransformer.TransformFromInModel(in)));
			return ResponseEntity.ok().body(res);
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	@PutMapping(PathCte.EXPENSE_UPDATE_CLAIM_PATH)
	public ResponseEntity<APIExpenseClaimOut> updateExpenseClaim(@RequestBody APIExpenseClaimIn in) {
		try {
			APIExpenseClaimOut res = ExpenseClaimTransformer
					.TransfromToOutModel(ecService.updateExpenseClaim(ExpenseClaimTransformer.TransformFromInModel(in)));
			return ResponseEntity.ok().body(res);
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	@DeleteMapping(PathCte.EXPENSE_DELETE_CLAIM_PATH)
	public ResponseEntity<String> deleteExpenseClaim(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok().body(ecService.deleteExpenseClaim(id));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
}
