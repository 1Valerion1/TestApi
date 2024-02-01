package org.test.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoDto {
    private String message;
    private String status;

    @JsonCreator
    public InfoDto(@JsonProperty("status") String status,@JsonProperty("message") String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
