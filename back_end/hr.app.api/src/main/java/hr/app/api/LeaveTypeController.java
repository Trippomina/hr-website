package hr.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hr.app.api.common.PathCte;
import hr.app.api.model.APILeaveType;
import hr.app.api.model.transformer.LeaveTypeTransformer;
import hr.app.service.LeaveTypeService;
import hr.app.service.exception.BusinessException;

@RestController
public class LeaveTypeController {

	@Autowired
	LeaveTypeService leaveTypeService;

	@GetMapping(PathCte.LEAVE_TYPE_PATH)
	public ResponseEntity<List<APILeaveType>> getLeaveTypes() {
		try {
			return ResponseEntity.ok()
					.body(LeaveTypeTransformer.TransformToOutModelList(leaveTypeService.getLeaveTypes()));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
}
