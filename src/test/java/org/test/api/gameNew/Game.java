package org.test.api.gameNew;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game {
    @JsonProperty("company")
    private String company;
    @JsonProperty("description")
    private String description;
    @JsonProperty("dlcs")
    private ArrayList<Dlc> dlcs;
    @JsonProperty("gameId")
    private Integer gameId;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("isFree")
    private Boolean isFree;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("publish_date")
    private LocalDateTime  publish_date;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("requiredAge")
    private Boolean requiredAge;
    @JsonProperty("requirements")
    private Requirements requirements;
    @JsonProperty("tags")
    private ArrayList<String> tags;
    @JsonProperty("title")
    private String title;

    @JsonCreator
    public Game(){

    }

    @JsonCreator
    public Game(@JsonProperty("company") String company,
                @JsonProperty("description") String description,
                @JsonProperty("dlcs") ArrayList<Dlc> dlcs,
                @JsonProperty("gameId") Integer gameId,
                @JsonProperty("genre") String genre,
                @JsonProperty("isFree") Boolean isFree,
                @JsonProperty("price") Integer price,
                @JsonProperty("publish_date") LocalDateTime  publish_date,
                @JsonProperty("rating") Integer rating,
                @JsonProperty("requiredAge") Boolean requiredAge,
                @JsonProperty("requirements") Requirements requirements,
                @JsonProperty("tags") ArrayList<String> tags,
                @JsonProperty("title") String title) {
        this.company = company;
        this.description = description;
        this.dlcs = dlcs;
        this.gameId = gameId;
        this.genre = genre;
        this.isFree = isFree;
        this.price = price;
        this.publish_date = publish_date;
        this.rating = rating;
        this.requiredAge = requiredAge;
        this.requirements = requirements;
        this.tags = tags;
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Dlc> getDlcs() {
        return dlcs;
    }

    public Integer getGameId() {
        return gameId;
    }

    public String getGenre() {
        return genre;
    }

    public Boolean getFree() {
        return isFree;
    }

    public Integer getPrice() {
        return price;
    }

    public LocalDateTime getPublish_date() {
        return publish_date;
    }

    public Integer getRating() {
        return rating;
    }

    public Boolean getRequiredAge() {
        return requiredAge;
    }

    public Requirements getRequirements() {
        return requirements;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }
}
