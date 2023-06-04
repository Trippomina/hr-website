package hr.app.business.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseClaimRepo extends CrudRepository<ExpenseClaim, String> {

}
