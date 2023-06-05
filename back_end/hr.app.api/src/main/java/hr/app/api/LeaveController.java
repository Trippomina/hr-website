package hr.app.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hr.app.api.common.PathCte;
import hr.app.api.model.in.APILeaveIn;
import hr.app.api.model.out.APILeaveOut;
import hr.app.api.model.transformer.LeaveTransformer;
import hr.app.business.model.Leave;
import hr.app.business.model.dto.StatisticsDTO;
import hr.app.service.LeaveService;
import hr.app.service.exception.BusinessException;

@RestController
public class LeaveController {

	@Autowired
	LeaveService leaveService;

	@PostMapping(PathCte.LEAVE_ADD_PATH)
	public ResponseEntity<APILeaveOut> createLeave(@PathVariable("employeeId") String employeeId,
			@PathVariable("leaveType") String leaveType, @RequestBody APILeaveIn in) {
		try {
			return ResponseEntity.ok().body(LeaveTransformer.TransformToOutModel(
					leaveService.addLeave(LeaveTransformer.TransformFromInModel(in), employeeId, leaveType)));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}

	@GetMapping(PathCte.LEAVE_GET_ALL_PATH)
	public ResponseEntity<List<APILeaveOut>> getAllLeaves() {
		try {
			List<Leave> leaves = leaveService.getLeaves();
			return ResponseEntity.ok().body(LeaveTransformer.TransformToOutModelList(leaves));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}

	@GetMapping(PathCte.LEAVE_GET_BY_EMPLOYEE_PATH)
	public ResponseEntity<List<APILeaveOut>> getLeavesByEmployee(@PathVariable("employeeId") String employeeId) {
		try {
			List<Leave> leaves = leaveService.getLeavesByEmployee(employeeId);
			return ResponseEntity.ok().body(LeaveTransformer.TransformToOutModelList(leaves));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}

	@GetMapping(PathCte.LEAVE_GET_BY_EMPLOYEE_FILTER_DATE_PATH)
	public ResponseEntity<List<APILeaveOut>> getLeavesByEmployeeFilterDate(
			@PathVariable("employeeId") String employeeId,
			@RequestParam("dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
			@RequestParam("dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo) {
		try {
			List<Leave> leaves = leaveService.getLeavesByEmployeeAndFromToDate(employeeId, dateFrom, dateTo);
			return ResponseEntity.ok().body(LeaveTransformer.TransformToOutModelList(leaves));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}

	@GetMapping(PathCte.LEAVE_GET_ALL_FILTER_DATE_PATH)
	public ResponseEntity<List<APILeaveOut>> getAllLeavesFilterDate(
			@RequestParam("dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
			@RequestParam("dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo) {
		try {
			List<Leave> leaves = leaveService.getLeavesByDate(dateFrom, dateTo);
			return ResponseEntity.ok().body(LeaveTransformer.TransformToOutModelList(leaves));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}

	@PutMapping(PathCte.LEAVE_UPDATE_PATH)
	public ResponseEntity<APILeaveOut> updateLeave(@PathVariable("id") String id,
			@PathVariable("leaveType") String leaveType, @RequestBody APILeaveIn in) {
		try {
			Leave leave = LeaveTransformer.TransformFromInModel(in);
			Leave updatedLeave = leaveService.updateLeave(leave, id, leaveType);
			return ResponseEntity.ok().body(LeaveTransformer.TransformToOutModel(updatedLeave));
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}

	@DeleteMapping(PathCte.LEAVE_DELETE_PATH)
	public ResponseEntity<String> deleteLeave(@PathVariable("id") String id) {
		try {
			String result = leaveService.deleteLeave(id);
			return ResponseEntity.ok().body(result);
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@GetMapping(PathCte.LEAVE_GET_STATISTICS_PATH)
	public ResponseEntity<List<StatisticsDTO>> getLeavesStatistics() {
		try {
			List<StatisticsDTO> statistics = leaveService.getLeavesStatistics();
			return ResponseEntity.ok().body(statistics);
		} catch (BusinessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}

}
