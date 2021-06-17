package apiTests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;

public class PostCreateUser {
    @Test
    public void postCreateTest() {

        RestAssured.baseURI = "https://reqres.in/api/users";

        File jsonCreateUser = new File("src/test/resources/chemas/postCreateUser.json");

        RestAssured.given()
                .body(jsonCreateUser)
                .post()
                .then()
                .log().all()
                .statusCode(201);
    }
}
