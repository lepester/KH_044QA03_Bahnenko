package apiTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import testClasses.BaseTest;

import java.io.File;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class GetDelayedResponse {

    @Test
    public void getDelayedResponse() {
        File delayedResponse = new File("src/test/resources/chemas/getDelayedResponse.json");

        Response response = when().get("https://reqres.in/api/users?delay=3");
            response.then()
                    .statusCode(200)
                    .assertThat().body(matchesJsonSchema(delayedResponse));
        System.out.println("Status Code is: " + response.statusCode());
    }
}
