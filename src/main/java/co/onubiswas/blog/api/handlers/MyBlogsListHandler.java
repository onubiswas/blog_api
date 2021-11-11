package co.onubiswas.blog.api.handlers;

import co.onubiswas.blog.api.models.domain.Blog;
import co.onubiswas.blog.api.models.res.BlogListResponse;
import co.onubiswas.blog.api.models.res.MyBlogListsResponse;
import co.onubiswas.blog.api.service.BlogsListService;
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
    public MyBlogListsResponse login(@RequestHeader("authorization") String auth ) {
        log.info("MyBlogsList request init");
        return svc.getMyBlogs(auth);

    }
}
