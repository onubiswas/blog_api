package co.onubiswas.blog.api.service;

import co.onubiswas.blog.api.models.domain.UserAccount;
import co.onubiswas.blog.api.models.req.RegistrationBody;
import co.onubiswas.blog.api.repository.UserAccountRepo;
import co.onubiswas.blog.api.utility.Crypto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
@Log4j2
public class UserRegistrationService {

    @Autowired
    public UserAccountRepo userRepo;

    private boolean validate(RegistrationBody body) {
        log.info("validating user request body: email");
        // check if it is a proper email -- it should contain @
        boolean valid = true;
        valid = StringUtils.contains(body.getEmail(), "@");

        log.info("validating user request body: password");

        // password should not be less than 6 characters
        if(body.getPassword().length() < 6) {
            valid = false;
        }
        return valid;
    }

    public void persist(UserAccount account){
        log.info("saving new user account into database");
        try{
            userRepo.save(account);
        } catch (DbActionExecutionException e) {
            String msg = String.format("user with email id %s already exists", account.getEmail());
            log.info(msg);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, msg, null);
        } catch (Exception e) {
            log.error(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "something went wrong in the server", null);
        }
    }


    public UserAccount createAccount(RegistrationBody body){
        if(!validate(body)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "re check your request body", null);
        }

        UserAccount account = new UserAccount();
        account.setName(body.getName());
        account.setEmail(body.getEmail());

        // usually add a salt to the existing password and hash it
        // here for demo purposes no salt added.
        account.setPassword(Crypto.demoHash(body.getPassword()));
        persist(account);

        return account;
    }
}
