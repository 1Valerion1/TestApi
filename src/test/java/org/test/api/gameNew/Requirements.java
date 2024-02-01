package org.test.api.gameNew;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Requirements {
    private Integer hardDrive;
    private String osName;
    private Integer ramGb;
    private String videoCard;

    @JsonCreator
    public Requirements(@JsonProperty("hardDrive") Integer hardDrive,
                        @JsonProperty("osName") String osName,
                        @JsonProperty("ramGb") Integer ramGb,
                        @JsonProperty("videoCard") String videoCard) {
        this.hardDrive = hardDrive;
        this.osName = osName;
        this.ramGb = ramGb;
        this.videoCard = videoCard;
    }

    public Integer getHardDrive() {
        return hardDrive;
    }

    public String getOsName() {
        return osName;
    }

    public Integer getRamGb() {
        return ramGb;
    }

    public String getVideoCard() {
        return videoCard;
    }
}

