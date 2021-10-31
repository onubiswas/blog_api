package co.onubiswas.blog.api.repository;

import co.onubiswas.blog.api.models.domain.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface UserAccountRepo extends CrudRepository<UserAccount, Integer> {

}
