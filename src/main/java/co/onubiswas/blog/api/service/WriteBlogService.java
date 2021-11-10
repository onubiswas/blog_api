package co.onubiswas.blog.api.service;

import co.onubiswas.blog.api.models.domain.Blog;
import co.onubiswas.blog.api.models.domain.UserAccount;
import co.onubiswas.blog.api.models.res.BlogWriteResponse;
import co.onubiswas.blog.api.repository.BlogRepo;
import co.onubiswas.blog.api.repository.UserAccountRepo;
import co.onubiswas.blog.api.utility.CryptoUtil;
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
    public CryptoUtil cryptoUtil;

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

    private String permit(String authToken) {
        log.info("starting token validation for write blog");
        // validate token  - token format - Bearer tosjl.gjsl.jsl
        String bearer = StringUtils.substring(authToken, 0, 7).toLowerCase();
        if (!"bearer ".equals(bearer)) {
            // raise invalid token format
            // status code 401
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "please use Bearer token format for the authorization header",
                    null);
        }
        String token = StringUtils.substring(authToken, 7);
        String userEmail = cryptoUtil.validateJWT(token); //token validation
        // check if the user exists
        UserAccount user = userTable.findUserByEmail(userEmail);

        // user does not exist
        if(null == user) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "user is not a valid user",
                    null
                    );
        }

        return userEmail;

    }

    private Boolean validateRequestBody(Blog blog) {
        if("".equals(blog.getTitle())) {
            blog.setTitle("untitled");
        }
        return true;
    }

    public BlogWriteResponse writeBlog(String authToken, Blog blog) {

        String email = permit(authToken);

        validateRequestBody(blog);
        blog.setEmail(email);


        log.info("saving blog details into database");
        //check the user exist in the system or not (email check)
        // then read author_name from user_accounts table to include in write blog.
        // persist
        saveBlog(blog);

        return new BlogWriteResponse(blog.getId());
    }
}
