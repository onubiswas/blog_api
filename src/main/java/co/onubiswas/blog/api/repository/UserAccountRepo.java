package co.onubiswas.blog.api.repository;

import co.onubiswas.blog.api.models.domain.UserAccount;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//@Repository
public interface UserAccountRepo extends CrudRepository<UserAccount, Integer> {

    @Query("SELECT * from user_accounts WHERE email = :email")
    UserAccount findUserByEmail(@Param("email") String email);

}
