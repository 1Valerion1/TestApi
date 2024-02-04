package org.test.api.jwtToken;

import org.junit.jupiter.api.Test;
import org.test.api.Specifications;
import org.test.api.userNew.UserTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class TokenTest {
    @Test
    public void getTestAToken(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecOk200());

        JwtRequest jwt = new JwtRequest(UserTest.pass,UserTest.login);

       String token = given()
                .body(jwt)
                .when()
                .post("/api/login")
                .then()
                .log().all()
                .extract()
                .body().jsonPath().getString("token");

        assertThat(token, notNullValue());

        Token.setToken(token);

    }
}
