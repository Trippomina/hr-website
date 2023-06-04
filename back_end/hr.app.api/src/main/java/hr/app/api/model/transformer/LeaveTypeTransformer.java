package hr.app.api.model.transformer;

import java.util.List;
import java.util.stream.Collectors;
import hr.app.api.model.APILeaveType;
import hr.app.business.model.LeaveType;

public class LeaveTypeTransformer {

	public static APILeaveType TransformToOutModel(LeaveType l) {
		return APILeaveType.builder().id(l.getLeaveTypeId()).name(l.getLeaveTypeName()).build();
	}

	public static List<APILeaveType> TransformToOutModelList(List<LeaveType> list) {

		return list.stream().map(l -> TransformToOutModel(l)).collect(Collectors.toList());

	}
	
	public static LeaveType TransformFromInModel(APILeaveType l) {
		LeaveType res = new LeaveType();
		res.setLeaveTypeId(l.getId());
		res.setLeaveTypeName(l.getName());
		return res;
	}
	
}
