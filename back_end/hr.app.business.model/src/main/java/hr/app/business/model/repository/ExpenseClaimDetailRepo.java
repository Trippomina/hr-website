package hr.app.business.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hr.app.business.model.ExpenseClaimDetail;
import hr.app.business.model.dto.StatisticsDTO;

@Repository
public interface ExpenseClaimDetailRepo extends CrudRepository<ExpenseClaimDetail, String> {
	public Optional<ExpenseClaimDetail> findById(String id);

	public List<ExpenseClaimDetail> findAll();

	@Query(nativeQuery = true, name = "ExpenseClaimDetail.findExpenseClaimsStatistics")
	List<StatisticsDTO> findExpenseClaimsStatistics();
}