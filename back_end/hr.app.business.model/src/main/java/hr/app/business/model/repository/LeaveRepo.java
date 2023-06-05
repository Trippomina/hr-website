package hr.app.business.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hr.app.business.model.Leave;
import hr.app.business.model.dto.StatisticsDTO;

@Repository
public interface LeaveRepo extends CrudRepository<Leave, String> {
	public final static String FIND_BY_FROM_TO_DATE = "SELECT * FROM leave WHERE date_from >= :dateFrom AND date_to <= :dateTo";
	public final static String FIND_BY_EMPLOYEE_ID = "SELECT * FROM leave WHERE employee_id = :id";
	public final static String FIND_BY_EMPLOYEE_ID_AND_FROM_TO_DATE = "SELECT * FROM leave WHERE employee_id >= :id AND date_from =< :dateFrom AND date_to = :dateTo ";
	public final static String FIND_ALL_LEAVES_TYPES_COUNTS = "SELECT lt.leave_type_name AS type, COUNT(*) AS typeTotal FROM leave l JOIN leave_type lt ON l.leave_type_id = lt.leave_type_id GROUP BY lt.leave_type_name";

	public List<Leave> findAll();

	@Query(value = FIND_BY_FROM_TO_DATE, nativeQuery = true)
	public List<Leave> findByFromToDate(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);

	@Query(value = FIND_BY_EMPLOYEE_ID, nativeQuery = true)
	public List<Leave> findByEmployeeId(@Param("id") String id);

	@Query(value = FIND_BY_EMPLOYEE_ID_AND_FROM_TO_DATE, nativeQuery = true)
	public List<Leave> findByEmployeeIdAndFromToDate(@Param("id") String id, @Param("dateFrom") Date dateFrom,
			@Param("dateTo") Date dateTo);

	@Query(nativeQuery = true, name = "Leave.findLeavesStatistics")
	List<StatisticsDTO> findLeavesStatistics();
}
