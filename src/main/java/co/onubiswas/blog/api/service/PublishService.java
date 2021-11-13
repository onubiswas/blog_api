package co.onubiswas.blog.api.service;

import co.onubiswas.blog.api.models.domain.Blog;
import co.onubiswas.blog.api.models.res.PublishResponse;
import co.onubiswas.blog.api.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublishService {
    @Autowired
    public BlogRepo repo;
    

    public PublishResponse publish(Integer id){
        repo.publishBlog(id.toString());

        return new PublishResponse("ok");
    }

}
