package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class IdApiTests {

    @DisplayName("You can't get any user via non existing id")
    @Test
    void getNotExistedUserById() {

        given()
                .log().all()
                .get("/users/0")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }

}
