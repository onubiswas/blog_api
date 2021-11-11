package co.onubiswas.blog.api.handlers;

import co.onubiswas.blog.api.models.res.BlogListsResponse;
import co.onubiswas.blog.api.service.MyBlogsListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(path="api/v1/my-blogs")
public class MyBlogsListHandler {

    @Autowired
    public MyBlogsListService svc;

    @GetMapping
    public BlogListsResponse myBlogList(@RequestHeader("authorization") String auth ) {
        log.info("MyBlogsList request init");
        return svc.getMyBlogs(auth);

    }
}
