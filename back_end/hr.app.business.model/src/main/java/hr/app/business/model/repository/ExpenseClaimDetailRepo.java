package hr.app.business.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hr.app.business.model.ExpenseClaimDetail;

@Repository
public interface ExpenseClaimDetailRepo extends CrudRepository<ExpenseClaimDetail, String> {
}
