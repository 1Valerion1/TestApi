package org.test.api.train;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseData {
    @JsonProperty("1")
    private  String _1;
    private  String _2;
    private  NumbersPow numbersPow;
    @JsonProperty("true")
    private Boolean trueFalse;
    @JsonProperty("что то на русском")
    private  String russian;
    @JsonProperty("bmw:users")
    private  String nickName;
    @JsonProperty("'single_quotes'")
    private  String quotes;

    public ResponseData() {
    }

    @JsonCreator
    public ResponseData(
            @JsonProperty("1") String _1,
            @JsonProperty("_2") String _2,
            @JsonProperty("numbersPow") NumbersPow numbersPow,
            @JsonProperty("true") Boolean trueFalse,
            @JsonProperty("что то на русском") String russian,
            @JsonProperty("bmw:users") String nickName,
            @JsonProperty("'single_quotes'") String quotes) {

        this._1 = _1;
        this._2 = _2;
        this.numbersPow = numbersPow;
        this.trueFalse = trueFalse;
        this.russian = russian;
        this.nickName = nickName;
        this.quotes = quotes;
    }

    public String get_1() {
        return _1;
    }

    public String get_2() {
        return _2;
    }

    public NumbersPow getNumbersPow() {
        return numbersPow;
    }

    public Boolean getTrueFalse() {
        return trueFalse;
    }

    public String getRussian() {
        return russian;
    }

    public String getNickName() {
        return nickName;
    }

    public String getQuotes() {
        return quotes;
    }
}
