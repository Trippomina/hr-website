package hr.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hr.app.api.common.PathCte;
import hr.app.api.model.in.APIExpenseClaimDetailIn;
import hr.app.api.model.in.APIExpenseClaimIn;
import hr.app.api.model.out.APIExpenseClaimDetailOut;
import hr.app.api.model.out.APIExpenseClaimOut;
import hr.app.api.model.transformer.ExpenseClaimDetailTransformer;
import hr.app.api.model.transformer.ExpenseClaimTransformer;
import hr.app.service.ExpenseClaimDetailService;
import hr.app.service.exception.BusinessException;

@RestController
public class ExpenseClaimDetailController {
	
	@Autowired
	private ExpenseClaimDetailService ecdService;

	@PostMapping("/ecd/add")
	public ResponseEntity<APIExpenseClaimDetailOut> addExpenseClaim(@RequestBody APIExpenseClaimDetailIn in) {
		try {
			APIExpenseClaimDetailOut res = ExpenseClaimDetailTransformer
					.TransfromToOutModel(ecdService.addExpenseClaimDetail(ExpenseClaimDetailTransformer.TransformFromInModel(in)));
			return ResponseEntity.ok().body(res);
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
}
