package apiTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetUserNotFound {
    @Test
    public void getUserNotFound() {

        Response response = when().get("https://reqres.in/api/users/23");
        response.then().statusCode(404);

        System.out.println("Status Code is: " + response.statusCode());

    }
}
