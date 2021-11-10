package co.onubiswas.blog.api.utility;

import co.onubiswas.blog.api.ApplicationConfiguration;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

import static org.apache.commons.lang3.time.DateUtils.addHours;

@Log4j2
@Component
public class CryptoUtil {

    @Autowired
    public ApplicationConfiguration conf;

    public static String demoHash(String password) {
        return "0000" + password + "#";
    }

    public String generateJWT(String email) {
        Date d = new Date();

        Algorithm algorithm = Algorithm.HMAC256(conf.getTokenKey());
        String token = JWT.create()
                .withIssuer(conf.getTokenIssuer())
                .withClaim("user_email", email)
                .withExpiresAt(addHours(d, 24*7)) // 7 days
                .withIssuedAt(d)
                .sign(algorithm);
        return token;
    }

    public String validateJWT(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(conf.getTokenKey());
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(conf.getTokenIssuer())
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            String email = null;
            if(null != jwt.getClaims().get("user_email")) {
                email = jwt.getClaims().get("user_email").asString();
            } else {
                // if email is not present the token has to be invalid as while signing email is
                // added in the payload scopes
                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Invalid Token", null);
            }
            return email;
        } catch (JWTVerificationException exception) {
            //Invalid signature/claims
            log.info(exception);
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Invalid Token", null);
        } catch (Exception e) {
            log.error(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "something went wrong in the server", null);
        }


    }

}
