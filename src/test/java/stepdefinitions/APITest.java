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
        data.put("name", "Lenovo Book");
        data.put("job", "leader35678");

        given().contentType("application/json").body(data).
                when().post("https://restful-api.dev/objects").
                then().statusCode(201).log().all();
    }
}