package co.onubiswas.blog.api.service;

import co.onubiswas.blog.api.models.domain.Blog;
import co.onubiswas.blog.api.models.domain.UserAccount;
import co.onubiswas.blog.api.models.req.NewBlogRequestBody;
import co.onubiswas.blog.api.models.res.BlogListResponse;
import co.onubiswas.blog.api.models.res.MyBlogListsResponse;
import co.onubiswas.blog.api.repository.BlogRepo;
import co.onubiswas.blog.api.repository.UserAccountRepo;
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

    public MyBlogListsResponse getMyBlogs(String auth) {
        // validate token and extract email
        String email = validate.permit(auth);
        log.info("Retrieving list of blogs from the database");
        // check on the blogs table with the email_id and return the list of title...
        List<Blog> blogs =  repo.findUserBlogs(email);

        MyBlogListsResponse response = new MyBlogListsResponse();
        if (null != blogs) {
            for(int i=0;i<blogs.size();i++) {
                Blog blog = blogs.get(i);
                response.addBlogTitle(new MyBlogListsResponse.MinimalBlogDetail(blog.getId(), blog.getTitle()));
            }
        }
        return response;
    }
}
