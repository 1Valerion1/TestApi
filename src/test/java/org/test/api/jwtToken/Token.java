package org.test.api.jwtToken;

public class Token {

    private static String token;

    public static void setToken(String newToken) {
        token = newToken;
    }

    public static String getToken() {
        return token;
    }
}
