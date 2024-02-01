package org.test.api.userNew;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.test.api.gameNew.Game;

import java.util.ArrayList;

public class UserData {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("login")
    private String login;
    @JsonProperty("pass")
    private String pass;

    @JsonProperty("games")
    private  ArrayList<Game> games;

    public UserData() {
    }
    @JsonCreator
    public UserData(@JsonProperty("id") Integer id,
                    @JsonProperty("login") String login,
                    @JsonProperty("pass") String pass,
                    @JsonProperty("games") ArrayList<Game> games) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.games = games;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
}
