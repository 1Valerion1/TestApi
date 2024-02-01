package org.test.api.jwtToken;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.test.api.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.test.api.gameNew.GameTest.token;

public class TokenTest {
    @Test
    public void getTestAToken(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecOk200());

        JwtRequest jwt = new JwtRequest("b6aa2039-","VadimMadiv b6aa2039-");

        token = given()
                .body(jwt)
                .when()
                .post("/api/login")
                .then()
                .log().all()
                .extract()
                .body().jsonPath().getString("");

        assertThat(token, notNullValue());

    }
}
