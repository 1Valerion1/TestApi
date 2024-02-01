package org.test.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    private final static String URL = "http://85.192.34.140:8080/";
    public static RequestSpecification requestSpec(){
        return  new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestSpecMult(){
        return  new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.MULTIPART)
                .build();
    }

    public static ResponseSpecification responseSpecOk200(){
        return  new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpecCreated201(){
        return  new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }
    public static ResponseSpecification responseSpecBad400(){
        return  new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
    public static ResponseSpecification responseSpecNotFound404(){
        return  new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }

    public static void installSpecification (RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }


}
