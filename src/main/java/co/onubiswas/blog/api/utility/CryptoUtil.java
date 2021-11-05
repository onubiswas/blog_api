package co.onubiswas.blog.api.utility;

import co.onubiswas.blog.api.ApplicationConfiguration;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

import static org.apache.commons.lang3.time.DateUtils.addHours;


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

    public String generateDummyToken(String payload) {

        return  Base64.getEncoder().encodeToString(payload.getBytes());
    }

    public String decodeDummyToken(String token) {
        byte[] decodedBytes = Base64.getDecoder().decode(token);
        return new String(decodedBytes);

    }
}
