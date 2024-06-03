package util;

import java.security.SecureRandom;
import java.util.Base64;

public class Tools {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
    
    public static void main(String[] args) {
        String token = generateNewToken();
        System.out.println(token);
    }
}
