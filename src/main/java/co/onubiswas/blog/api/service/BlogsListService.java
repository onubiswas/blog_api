package co.onubiswas.blog.api.service;

import co.onubiswas.blog.api.models.domain.Blog;
import co.onubiswas.blog.api.models.res.BlogListsResponse;
import co.onubiswas.blog.api.models.res.BlogWriteResponse;
import co.onubiswas.blog.api.repository.BlogRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class BlogsListService {

    @Autowired
    public BlogRepo repo;

    public BlogListsResponse getBlogs(){
        // fetch all the blogs that are published
        log.info("Retrieving list of blogs from the database");
        List<Blog> blogs= repo.findAllBlogs();

        BlogListsResponse response= new BlogListsResponse();
        if(null!= blogs){
            for(int i=0; i< blogs.size(); i++){
                Blog blog= blogs.get(i);
                response.addBlogTitle(new BlogListsResponse.MinimalBlogDetail(blog.getId(), blog.getTitle()));
            }
        }
        return response;

    }
}
