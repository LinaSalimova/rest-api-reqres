package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import models.UserBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.*;

public class UsersApiTests {

    @DisplayName("You can create user with success fields name and job")
    @Test
    void successCreateUser() {
        RestAssured.filters(new AllureRestAssured());
        UserBody data = new UserBody();
        data.setName("Lina");
        data.setJob("tester");

        step("Verify created user data", () -> {
            UserBody response = given()
                .spec(loginRequestSpecBase)
                .body(data)
                .post("/users")
                .then()
                .spec(createUserResponseSpec)
                .extract().as(UserBody.class);
            step("Check response", () ->
        assertEquals(("Lina"), response.getName()));
        assertEquals(("tester"), response.getJob());
        });
    }

    @DisplayName("You can create user with empty fields name and job")
    @Test
    void createUserWithoutData() {
        RestAssured.filters(new AllureRestAssured());
        UserBody data = new UserBody();
        data.setName(" ");
        data.setJob(" ");
        step("Verify created user data", () -> {
            UserBody response = given()
                .spec(loginRequestSpecBase)
                .body(data)
                .post("/users")
                .then()
                .spec(userWithEmptyFieldsResponseSpec)
                .extract().as(UserBody.class);
        step("Check response", () ->
        assertEquals((" "), response.getName()));
        assertEquals((" "), response.getJob());
    });
}

    @DisplayName("You can update existing user")
    @Test
    void updateUserData() {
        RestAssured.filters(new AllureRestAssured());
        UserBody data = new UserBody();
        data.setName("morpheus");
        data.setJob("zion resident");

        step("Update existing user", () -> {
            UserBody response = given()
                .spec(loginRequestSpecBase)
                .body(data)
                .patch("/users/2")
                .then()
                .spec(updateExistingUserResponseSpec)
                .extract().as(UserBody.class);
            step("Check response", () ->
            assertEquals(("morpheus"), response.getName()));
            assertEquals(("zion resident"), response.getJob());
        });
    }
}
