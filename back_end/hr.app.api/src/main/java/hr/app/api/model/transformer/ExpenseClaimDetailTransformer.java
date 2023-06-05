package hr.app.api.model.transformer;

import java.util.List;
import java.util.stream.Collectors;

import hr.app.api.model.in.APIExpenseClaimDetailIn;
import hr.app.api.model.out.APIExpenseClaimDetailOut;
import hr.app.business.model.ExpenseClaimDetail;

public class ExpenseClaimDetailTransformer {
	public static APIExpenseClaimDetailOut TransfromToOutModel(ExpenseClaimDetail ecd) {
		APIExpenseClaimDetailOut res = new APIExpenseClaimDetailOut();
		res.setId(ecd.getEcDtlId());
		res.setEc_type(ecd.getEcType());
		res.setSubmission_date(ecd.getSubmissionDate());
		res.setDescription(ecd.getDescription());
		res.setTotal(ecd.getTotal());
		return res;
	}

	public static List<APIExpenseClaimDetailOut> TransformToOutModelList(List<ExpenseClaimDetail> list) {
		return list.stream().map(ecd -> TransfromToOutModel(ecd)).collect(Collectors.toList());
	}

	public static ExpenseClaimDetail TransformFromInModel(APIExpenseClaimDetailIn ecd) {
		ExpenseClaimDetail res = new ExpenseClaimDetail();
		res.setEcType(ecd.getEc_type());
		res.setSubmissionDate(ecd.getSubmission_date());
		res.setDescription(ecd.getDescription());
		res.setTotal(ecd.getTotal());
		return res;
	}

	public static List<ExpenseClaimDetail> TransformFromInModelList(List<APIExpenseClaimDetailIn> list) {
		return list.stream().map(ecd -> TransformFromInModel(ecd)).collect(Collectors.toList());
	}
}
