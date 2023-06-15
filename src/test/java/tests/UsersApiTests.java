package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class UsersApiTests {

    @DisplayName("You can create user with success fields name and job")
    @Test
    void successCreateUser() {
        String userBody = "{\"name\": \"Lina\",\"job\": \"tester\"}";// BAD PRACTICE

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(userBody)
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("Lina"))
                .body("job", is("tester"))
                .body("id", notNullValue());
    }

    @DisplayName("You can create user with empty fields name and job")
    @Test
    void createUserWithoutData() {
        String userBodyWithoutData = "{\"name\": \"\",\"job\": \"\"}";// BAD PRACTICE

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(userBodyWithoutData)
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is(""))
                .body("job", is(""))
                .body("id", notNullValue());
    }

    @DisplayName("You can update existing user")
    @Test
    void updateUserData() {
        String updateUserBody = "{\"name\": \"morpheus\",\"job\": \"zion resident\"}";// BAD PRACTICE

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(updateUserBody)
                .patch("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"))
                .body("updatedAt", notNullValue());
    }

    @DisplayName("You can get existing user via his system id")
    @Test
    void getExistUserById() {

        given()
                .log().uri()
                .log().body()
                .get("/users/9")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.first_name", is("Tobias"));
    }
}
