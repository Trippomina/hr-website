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
import hr.app.api.model.in.APIExpenseClaimDetailIn;
import hr.app.api.model.out.APIExpenseClaimDetailOut;
import hr.app.api.model.transformer.ExpenseClaimDetailTransformer;
import hr.app.business.model.dto.StatisticsDTO;
import hr.app.service.ExpenseClaimDetailService;
import hr.app.service.exception.BusinessException;

@RestController
public class ExpenseClaimDetailController {

	@Autowired
	private ExpenseClaimDetailService ecdService;

	@GetMapping(PathCte.EXPENSE_CLAIM_DETAIL_GET_STATISTICS_PATH)
	public ResponseEntity<List<StatisticsDTO>> getExpenseClaimsStatistics() {
		try {
			return ResponseEntity.ok().body(ecdService.getExpenseClaimsStatistics());
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@PostMapping(PathCte.EXPENSE_CLAIM_DETAIL_ADD_PATH)
	public ResponseEntity<APIExpenseClaimDetailOut> createExpenseClaim(@PathVariable("ecId") String ecId,
			@RequestBody APIExpenseClaimDetailIn in) {
		try {
			APIExpenseClaimDetailOut res = ExpenseClaimDetailTransformer.TransfromToOutModel(
					ecdService.addExpenseClaimDetail(ExpenseClaimDetailTransformer.TransformFromInModel(in), ecId));
			return ResponseEntity.ok().body(res);
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@PutMapping(PathCte.EXPENSE_CLAIM_DETAIL_UPDATE_PATH)
	public ResponseEntity<APIExpenseClaimDetailOut> updateExpenseClaim(@PathVariable("id") String id,
			@RequestBody APIExpenseClaimDetailIn in) {
		try {
			APIExpenseClaimDetailOut res = ExpenseClaimDetailTransformer.TransfromToOutModel(
					ecdService.updateExpenseClaimDetail(ExpenseClaimDetailTransformer.TransformFromInModel(in), id));
			return ResponseEntity.ok().body(res);
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@DeleteMapping(PathCte.EXPENSE_CLAIM_DETAIL_DELETE_PATH)
	public ResponseEntity<String> deleteExpenseClaim(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok().body(ecdService.deleteExpenseClaimDetail(id));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

}
