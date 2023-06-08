package hr.app.api.model.transformer;

import java.util.List;
import java.util.stream.Collectors;

import hr.app.api.common.DateUtils;
import hr.app.api.model.in.APILeaveIn;
import hr.app.api.model.out.APILeaveOut;
import hr.app.business.model.Leave;

public class LeaveTransformer {
	public static Leave TransformFromInModel(APILeaveIn l) {
		Leave res = new Leave();
		res.setDateFrom(l.getDate_from());
		res.setDateTo(l.getDate_to());
		res.setDays(DateUtils.getDaysBetween(l.getDate_from(), l.getDate_to()));
		res.setNote(l.getNote());
		return res;
	}

	public static List<APILeaveOut> TransformToOutModelList(List<Leave> list) {
		return list.stream().map(l -> TransformToOutModel(l)).collect(Collectors.toList());
	}

	public static APILeaveOut TransformToOutModel(Leave l) {
		APILeaveOut res = new APILeaveOut();
		res.setId(l.getLeaveId());
		res.setEmployee_name(l.getEmployee().getFullName());
		res.setLeave_type(LeaveTypeTransformer.TransformToOutModel(l.getLeaveType()));
		res.setDate_from(l.getDateFrom());
		res.setDate_to(l.getDateTo());
		res.setDays(l.getDays());
		res.setNote(l.getNote());
		return res;
	}
}
