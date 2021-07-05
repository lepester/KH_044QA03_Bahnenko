package apiTests;

import io.restassured.response.Response;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import org.testng.annotations.Test;

import java.io.File;

public class GetSingleUser {

    @Test
    public void getSingleUser() {
        File singleUser = new File("src/test/resources/chemas/getSingleUser.json");

        Response response = when().get("https://reqres.in/api/users/{id}", 2);
        response.then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchema(singleUser));
        System.out.println("Status Code is: " + response.statusCode());
    }
}
