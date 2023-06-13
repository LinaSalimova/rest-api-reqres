package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresTests extends TestBase {
    /*
  1. Make request (POST) to https://reqres.in/api/login
      with body { "email": "eve.holt@reqres.in", "password": "cityslicka" }
  2. Get response { "token": "QpwL5tke4Pnpja7X4" }
  3. Check token is QpwL5tke4Pnpja7X4
   */
    @Test
    void successLogin() {
        String loginBody = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}";// BAD PRACTICE

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(loginBody)
                .post("/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }


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
