package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class MySpecificationForRestAssured {
    public static void create(String urlBase) {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(urlBase)
                .setContentType(ContentType.JSON)
                .build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}

