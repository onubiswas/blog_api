package co.onubiswas.blog.api.utility;

import java.util.Base64;

public class Crypto {
    public static String demoHash(String password) {
        return "0000" + password + "#";
    }

    public static String generateDummyToken(String payload) {
        return  Base64.getEncoder().encodeToString(payload.getBytes());
    }

    public static String decodeDummyToken(String token) {
        byte[] decodedBytes = Base64.getDecoder().decode(token);
        return new String(decodedBytes);

    }
}
