package co.onubiswas.blog.api.utility;

import co.onubiswas.blog.api.models.domain.UserAccount;
import co.onubiswas.blog.api.repository.UserAccountRepo;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Log4j2
@Component
public class ValidateToken {

    @Autowired
    public CryptoUtil cryptoUtil;

    @Autowired
    public UserAccountRepo userTable;


    public String permit(String authToken) {
        log.info("starting token validation ");
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
}
