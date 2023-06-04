package hr.app.business.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseClaimDetailRepo extends CrudRepository<ExpenseClaimDetail, String> {

}
