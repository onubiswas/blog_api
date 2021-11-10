package co.onubiswas.blog.api.handlers;

import co.onubiswas.blog.api.models.req.LoginBody;
import co.onubiswas.blog.api.models.res.LoginResponse;
import co.onubiswas.blog.api.service.UserLoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/login")
@Log4j2
class UserLoginHandler {

    private UserLoginService service;

    @Autowired
    public UserLoginHandler( UserLoginService service){
        this.service= service;
    }
    @PostMapping
    public LoginResponse login(@RequestBody LoginBody loginDetails) {
        log.info("login request init");
        return service.loginAccount(loginDetails);
    }
}
