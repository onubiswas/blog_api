package co.onubiswas.blog.api.handlers;


import co.onubiswas.blog.api.models.req.NewBlogRequestBody;
import co.onubiswas.blog.api.models.res.BlogWriteResponse;
import co.onubiswas.blog.api.service.WriteBlogService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Component
@RestController
public class WriteBlogHandler {

    @Autowired
    public WriteBlogService writeBlogService;

    @PostMapping(path="api/v1/blogs/new")
    public BlogWriteResponse blog(@RequestHeader("authorization") String auth, @RequestBody NewBlogRequestBody blog) {
        log.info("WriteBlog request init");
        return writeBlogService.writeBlog(auth, blog);

    }
}
