package hr.app.business.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hr.app.business.model.ExpenseClaim;

@Repository
public interface ExpenseClaimRepo extends CrudRepository<ExpenseClaim, String> {

	public final static String FIND_BY_EMPLOYEE_ID = "SELECT * FROM expense_claim WHERE employee_id = :id";

	public List<ExpenseClaim> findAll();

	@Query(value = FIND_BY_EMPLOYEE_ID, nativeQuery = true)
	public List<ExpenseClaim> findByEmployeeId(@Param("id") String id);

//    @Query(nativeQuery = true, name = "ExpenseClaim.findExpenseClaimStatistics")
//    List<StatisticsDTO> findLeavesStatistics();
}
