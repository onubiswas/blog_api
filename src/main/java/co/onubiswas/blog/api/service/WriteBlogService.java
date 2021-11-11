package co.onubiswas.blog.api.service;

import co.onubiswas.blog.api.models.domain.Blog;
import co.onubiswas.blog.api.models.domain.UserAccount;
import co.onubiswas.blog.api.models.req.NewBlogRequestBody;
import co.onubiswas.blog.api.models.res.BlogWriteResponse;
import co.onubiswas.blog.api.repository.BlogRepo;
import co.onubiswas.blog.api.repository.UserAccountRepo;
import co.onubiswas.blog.api.utility.CryptoUtil;
import co.onubiswas.blog.api.utility.ValidateToken;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Log4j2
@Component
public class WriteBlogService {

    @Autowired
    public BlogRepo repo;

    @Autowired
    public UserAccountRepo userTable;

    public void saveBlog(Blog blog){
        try{
            repo.save(blog);
        } catch (Exception e) {
            log.error(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "something went wrong in the server", null);
        }
    }

    @Autowired
    public ValidateToken validate;

    private Blog validateRequestBody(NewBlogRequestBody body) {
        if("".equals(body.getTitle())) {
            body.setTitle("untitled");
        }
        return body.getBlog();
    }

    public BlogWriteResponse writeBlog(String authToken, NewBlogRequestBody body) {

        String email = validate.permit(authToken);
        Blog blog = validateRequestBody(body);
        blog.setEmail(email);


        log.info("saving blog details into database");
        //check the user exist in the system or not (email check)
        // then read author_name from user_accounts table to include in write blog.
        // persist
        saveBlog(blog);

        return new BlogWriteResponse(blog.getId());
    }
}
