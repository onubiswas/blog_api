package co.onubiswas.blog.api.handlers;

import co.onubiswas.blog.api.models.req.RegistrationBody;
import co.onubiswas.blog.api.models.res.RegistrationResponse;
import co.onubiswas.blog.api.service.UserRegistrationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="api/v1/register")
@Log4j2
public class UserRegistrationHandler {

    private final UserRegistrationService svc;

    @Autowired
    public UserRegistrationHandler(UserRegistrationService svc) {
        this.svc = svc;
    }

    @PostMapping
    public RegistrationResponse register(@RequestBody RegistrationBody body){
        log.info("registration request init");
        svc.createAccount(body);

        return new RegistrationResponse("ok");
    }

}
