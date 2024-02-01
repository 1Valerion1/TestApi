package org.test.api.jwtToken;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtRequest {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    @JsonCreator
    public JwtRequest(@JsonProperty("password") String password,@JsonProperty("username") String username) {
        this.username = username;
        this.password = password;
    }
}
