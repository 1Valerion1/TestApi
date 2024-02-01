package org.test.api.gameNew;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dlc {
    @JsonProperty("description")
    private String description;
    @JsonProperty("dlcName")
    private String dlcName;
    @JsonProperty("isDlcFree")
    private Boolean isDlcFree;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("similarDlc")
    private SimilarDlc similarDlc;

    @JsonCreator
    public Dlc(
            @JsonProperty("description") String description,
            @JsonProperty("dlcName") String dlcName,
            @JsonProperty("isDlcFree") Boolean isDlcFree,
            @JsonProperty("price") Integer price,
            @JsonProperty("rating") Integer rating,
            @JsonProperty("similarDlc") SimilarDlc similarDlc) {
        this.description = description;
        this.dlcName = dlcName;
        this.isDlcFree = isDlcFree;
        this.price = price;
        this.rating = rating;
        this.similarDlc = similarDlc;
    }
}
