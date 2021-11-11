package co.onubiswas.blog.api.service;

import co.onubiswas.blog.api.models.domain.Blog;
import co.onubiswas.blog.api.models.res.BlogListsResponse;
import co.onubiswas.blog.api.repository.BlogRepo;
import co.onubiswas.blog.api.utility.ValidateToken;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class MyBlogsListService {

    @Autowired
    public ValidateToken validate;

    @Autowired
    public BlogRepo repo;

    public BlogListsResponse getMyBlogs(String auth) {
        // validate token and extract email
        String email = validate.permit(auth);
        log.info("Retrieving my list of blogs from the database");
        // check on the blogs table with the email_id and return the list of title...
        List<Blog> blogs =  repo.findUserBlogs(email);

        BlogListsResponse response = new BlogListsResponse();
        if (null != blogs) {
            for(int i=0;i<blogs.size();i++) {
                Blog blog = blogs.get(i);
                response.addBlogTitle(new BlogListsResponse.MinimalBlogDetail(blog.getId(), blog.getTitle()));
            }
        }
        return response;
    }
}
