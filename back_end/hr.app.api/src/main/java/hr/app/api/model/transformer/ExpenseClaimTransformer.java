package hr.app.api.model.transformer;

import java.util.List;
import java.util.stream.Collectors;
import hr.app.api.model.in.APIExpenseClaimIn;
import hr.app.api.model.out.APIExpenseClaimOut;
import hr.app.business.model.ExpenseClaim;

public class ExpenseClaimTransformer {

	public static APIExpenseClaimOut TransfromToOutModel(ExpenseClaim ed) {
		APIExpenseClaimOut res = new APIExpenseClaimOut();
		res.setId(ed.getEcId());
		res.setEmployee_name(ed.getEmployee().getFullName());
		res.setSubmission_date(ed.getSubmissionDate());
		res.setDescription(ed.getDescription());
		res.setTotal(ed.getTotal());
		res.setStatus(ed.getStatus());
		res.setDetails(ExpenseClaimDetailTransformer.TransformToOutModelList(ed.getExpenseClaimDetails()));
		return res;
	}

	public static List<APIExpenseClaimOut> TransformToOutModelList(List<ExpenseClaim> list) {
		return list.stream().map(ed -> TransfromToOutModel(ed)).collect(Collectors.toList());
	}

	public static ExpenseClaim TransformFromInModel(APIExpenseClaimIn ed) {
		ExpenseClaim res = new ExpenseClaim();
		res.setSubmissionDate(ed.getSubmission_date());
		res.setDescription(ed.getDescription());
		res.setStatus(ed.getStatus());
		res.setTotal(ed.getTotal());
		return res;
	}
}
