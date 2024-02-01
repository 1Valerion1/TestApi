package org.test.api.userNew;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.test.api.InfoDto;
import org.test.api.Specifications;
import org.test.api.gameNew.GameTest;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {

   private static String newPassword = "pass";

    @Test
    @Order(1)
    public void successRegTest(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecCreated201());

       for (int i = 0;i < 1; i++) {

            String pass = UUID.randomUUID().toString().substring(0, 9);
            String login = "VadimMadiv " + pass;


            UserData userData = new UserData(null, login, pass, null);

            UserData userData2 = given()
                    .body(userData)
                    .when()
                    .post("/api/signup")
                    .then()
                    .log().all()
                    .extract()
                    .body().jsonPath().getObject("register_data", UserData.class);

            assertThat(userData2.getId(), notNullValue());
            assertThat(userData2.getLogin(), notNullValue());
            assertThat(userData2.getPass(), notNullValue());

        }

    }



    @Test
    @Order(2)
    public void getPutUser(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecOk200());


        InfoDto info = given()
                .auth().oauth2(GameTest.token)
                .body("{\"password\": \"" + newPassword + "\"}")
                .when()
                    .put("/api/user")
                .then()
                    .log().all()
                .extract()
                    .body().jsonPath().getObject("info", InfoDto.class);

            assertThat(info.getStatus(), equalTo("success"));
            assertThat(info.getMessage(), equalTo("User password successfully changed"));

    }
    @Test
    @Order(3)
    //Проверка,что у пользователя измененный пароль
    public void getGetUser(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecOk200());

        UserData userUp = given()
                .auth().oauth2(GameTest.token)
                .when()
                .get("/api/user")
                .then()
                .log().all()
                .extract()
                .body().jsonPath().getObject("", UserData.class);

        assertThat(userUp.getPass(), equalTo(newPassword));

    }

    @Test
    @Order(4)
    //Проверка,что пользователь удален
    public void getDeleteUser(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecOk200());

        InfoDto info = given()
                .auth().oauth2(GameTest.token)
                .when()
                .delete("/api/user")
                .then()
                .log().all()
                .extract()
                .body().jsonPath().getObject("info", InfoDto.class);

        assertThat(info.getMessage(),equalTo("success"));
        assertThat(info.getMessage(),equalTo("User successfully deleted"));

    }

}
