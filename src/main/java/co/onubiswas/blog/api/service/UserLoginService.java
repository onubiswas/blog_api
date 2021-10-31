package co.onubiswas.blog.api.service;

import co.onubiswas.blog.api.models.domain.UserAccount;
import co.onubiswas.blog.api.models.req.LoginBody;
import co.onubiswas.blog.api.models.req.RegistrationBody;
import co.onubiswas.blog.api.models.res.LoginResponse;
import co.onubiswas.blog.api.repository.UserAccountRepo;
import co.onubiswas.blog.api.utility.Crypto;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.function.ServerResponse;


@Service
@Log4j2
public class UserLoginService {

    // validate -- if it is proper email
    private boolean validate(LoginBody body) {
        log.info("validating user login body: email");
        // check if it is a proper email -- it should contain @
        boolean valid = true;
        valid= StringUtils.contains(body.getEmail(), "@");
        return valid;
    }

    @Autowired
    public UserAccountRepo repo;

    // getUserAccount
    private UserAccount getUserAccount(String email) {
        UserAccount account =  repo.findUserByEmail(email);
        if(null == account) {
            String msg = String.format("user with email %s does not exist", email);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, msg, null);

        }
        return account;
    }


    public LoginResponse loginAccount(LoginBody loginData){

        // todo

        // validate
        if(!validate(loginData)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "re-check your email id", null);
        }
        UserAccount user = getUserAccount(loginData.getEmail());


//      validate user details
        log.info("Checking password...");
        if(user.getPassword().equals(Crypto.demoHash(loginData.getPassword()))){
            return new LoginResponse(Crypto.generateDummyToken(user.getEmail()));
        }else{
            String msg = String.format("Invalid Password");
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, msg, null);
        }

    }
}
