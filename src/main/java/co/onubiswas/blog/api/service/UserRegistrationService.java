package co.onubiswas.blog.api.service;

import co.onubiswas.blog.api.models.domain.UserAccount;
import co.onubiswas.blog.api.models.req.RegistrationBody;
import co.onubiswas.blog.api.utility.Crypto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@Service
@Log4j2
public class UserRegistrationService {

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

    public int persist(UserAccount account) {
        log.info("saving new user account into database");

        // todo
        return 0;
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
        account.setSaltedPassword(Crypto.demoHash(body.getPassword()));

        return account;
    }
}
