package stepdefinitions;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APITest {

    @Test
    public void getUsers() {
        given().
                when().get("https://reqres.in/api/users?page=2").
                then().statusCode(200).log().all();
    }

    @Test
    void createUser() {
        HashMap data = new HashMap();
        data.put("name", "Test User");
        data.put("job", "Team Lead");

        given().contentType("application/json").body(data).
                when().post("https://reqres.in/api/users").
                then().statusCode(201).log().all();
    }
}