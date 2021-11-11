package co.onubiswas.blog.api.handlers;

import co.onubiswas.blog.api.models.domain.UserAccount;
import co.onubiswas.blog.api.models.res.BlogListResponse;
import co.onubiswas.blog.api.service.BlogsListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(path="api/v1/all-blogs")
public class BlogsListHandler {

//    @Autowired
//    public BlogsListService svc;

    @GetMapping
    public BlogListResponse login() {
//        log.info("BlogsList request init");
//        return svc.getBlogs();
        return null;
    }
}
