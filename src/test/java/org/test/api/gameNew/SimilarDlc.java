package org.test.api.gameNew;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SimilarDlc {
    private String dlcNameFromAnotherGame;
    private Boolean isFree;
    @JsonCreator
    public SimilarDlc(@JsonProperty("dlcNameFromAnotherGame") String dlcNameFromAnotherGame,@JsonProperty("isFree") Boolean isFree) {
        this.dlcNameFromAnotherGame = dlcNameFromAnotherGame;
        this.isFree = isFree;
    }

    public String getDlcNameFromAnotherGame() {
        return dlcNameFromAnotherGame;
    }

    public Boolean getFree() {
        return isFree;
    }
}