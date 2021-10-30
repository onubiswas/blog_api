package co.onubiswas.blog.api.handlers;

import co.onubiswas.blog.api.models.domain.UserAccount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/login")
public class BlogsListHandler {

    @GetMapping
    public UserAccount login() {
        return null; // todo
    }
}
