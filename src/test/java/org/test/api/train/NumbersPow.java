package org.test.api.train;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class NumbersPow {
    private Map<String, String> nums;

    public NumbersPow() {
    }

    @JsonCreator
    public NumbersPow(@JsonProperty("nums") Map<String, String> nums) {
        this.nums = nums;
    }

    public Map<String, String> getNums() {
        return nums;
    }
}
