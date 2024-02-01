package org.test.api.gameNew;

import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.test.api.InfoDto;
import org.test.api.Specifications;
import org.test.api.jwtToken.JwtRequest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameTest {

    public static String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJWYWRpbU1hZGl2IGI2YWEyMDM5LSIsImV4cCI6MTcwNjcxNzYyNCwiaWF0IjoxNzA2Njk5NjI0fQ.Ojqh-rcgZf8HDlf9Twy3yQwO-ZAM5MZErnLTQlBrFHTuRx-UW6IDaOC__S0esSd4uHPi3215lVYL3UOerVv6gA";
    private static  List<Game> allGames = new ArrayList<>(15);
    private static int addGameId = -1;


    @Test
    @Order(1)
    public void getTestBAllGames(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecOk200());

        allGames  = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("/api/user/games")
                .then()
                .log().all()
                .extract()
                .body().jsonPath().getList("",Game.class);

        assertThat(allGames,  hasSize((Matchers.greaterThan(-1) )));
    }

    @Test
    @Order(2)
    public void getTestCAddGame(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecCreated201());

        Game addGame = new Game(
                "Piranha Bytes",
                "Gothic 2 is a classic open-world RPG game set in a medieval fantasy world.",
                new ArrayList<Dlc>(Arrays.asList(
                        new Dlc("Night of the Raven expansion pack for Gothic 2",
                                "Night of the Raven",
                                false,
                                15,
                                8,
                                new SimilarDlc("DLC Gothic 2: Night of the Raven", false)
                        )
                )),
                2,
                "Action RPG",
                false,
                1999,
                LocalDateTime.of(2002, Month.NOVEMBER,29,00,00),
                9,
                false,
                new Requirements(2000, "Windows 98", 512, "DirectX 8 compatible GPU"),
                new ArrayList<>(Arrays.asList("RPG", "Open World", "Medieval Fantasy")),
                "Gothic 2"
        );

        Game addedGame = given()
                .auth().oauth2(token)
                .body(addGame)
                .when()
                .post("/api/user/games")
                .then()
                .log().all()
                .extract()
                .body().jsonPath().getObject("register_data",Game.class);

        assertThat(addedGame.getGameId(),notNullValue());
        assertThat(addedGame.getRequirements(),notNullValue());
        assertThat(addedGame.getDescription(),notNullValue());

        addGameId = addedGame.getGameId();

    }




    @Test
    @Order(3)
    public void getTestDAllGamesUp(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecOk200());

        List<Game> updatedGameList = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("/api/user/games")
                .then()
                .log().all()
                .extract()
                .body().jsonPath().getList("",Game.class);

        assertThat( updatedGameList, hasSize(allGames.size() + 1));

    }

    @Test
    @Order(4)
    public void getTestEDeleteGame(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecOk200());

        String responseBody = given()
                .auth().oauth2(token)
                .when()
                .delete("/api/user/games/"+ addGameId)
                .then()
                .log().all()
                .extract()
                .body().asString();

        JsonPath jsonPath = new JsonPath(responseBody);
        InfoDto info = jsonPath.getObject("info", InfoDto.class);

        assertThat(jsonPath.get("info.id"), is(nullValue()));

        assertThat(info.getStatus(),equalTo("success"));
        assertThat(info.getMessage(),equalTo("Game successfully deleted"));

    }




}
