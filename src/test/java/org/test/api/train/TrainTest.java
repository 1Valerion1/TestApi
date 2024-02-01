package org.test.api.train;

import org.junit.jupiter.api.Test;
import org.test.api.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class TrainTest {

    @Test
    public void testEasyNumsOk(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecOk200());

        ResponseData responseData = given()
                .when()
                    .get("/api/easy/nums")
                .then()
                    .log().all()
                .extract()
                    .body().jsonPath().getObject("",ResponseData.class);

        // Проверяем что поля не null
        assertThat(responseData.get_1(), notNullValue());
        assertThat(responseData.get_2(), notNullValue());
        assertThat(responseData.getNumbersPow(), notNullValue());
        assertThat(responseData.getTrueFalse(), notNullValue());
        assertThat(responseData.getRussian(), notNullValue());
        assertThat(responseData.getNickName(), notNullValue());
        assertThat(responseData.getQuotes(), notNullValue());

    }

    @Test
    public void testBadRequest(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecBad400());

        given().
                when()
                    .get("/api/bad-request")
                .then()
                    .body("description",notNullValue())
                    .body("statusCode", equalTo(400))
                    .log().all();

    }
    @Test
    public void testNotFound(){
        Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecNotFound404());

        given().
                when()
                .get("/api/invalid-url")
                .then()
                .body("description",notNullValue())
                .body("statusCode", equalTo(404))
                .log().all();

    }

}
