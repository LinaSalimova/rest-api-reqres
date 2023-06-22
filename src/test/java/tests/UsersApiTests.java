package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import models.UserBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.*;

public class UsersApiTests extends TestBase {

    @DisplayName("You can create user with success fields name and job")
    @Tags({@Tag("create"), @Tag("user")})
    @Test
    void successCreateUser() {
        RestAssured.filters(new AllureRestAssured());
        UserBody data = new UserBody();
        data.setName("Lina");
        data.setJob("tester");


        UserBody response = step("Verify created user data", () -> given()
                .spec(loginRequestSpecBase)
                .body(data)
                .post("/users")
                .then()
                .spec(createUserResponseSpec)
                .extract().as(UserBody.class));
        step("Check name in response", () ->
                assertEquals("Lina", response.getName()));

        step("Check job in response", () ->
                assertEquals("tester", response.getJob()));
    }


    @DisplayName("You can create user with empty fields name and job")
    @Tags({@Tag("empty"), @Tag("fields")})
    @Test
    void createUserWithoutData() {
        RestAssured.filters(new AllureRestAssured());
        UserBody data = new UserBody();
        data.setName(" ");
        data.setJob(" ");
            UserBody response = step("Verify created user data", () ->  given()
                    .spec(loginRequestSpecBase)
                    .body(data)
                    .post("/users")
                    .then()
                    .spec(userWithEmptyFieldsResponseSpec)
                    .extract().as(UserBody.class));
        step("Check name in response", () ->
            assertEquals((" "), response.getName()));
        step("Check job in response", () ->
            assertEquals((" "), response.getJob()));
    }

    @DisplayName("You can update existing user")
    @Tags({@Tag("update"), @Tag("user")})
    @Test
    void updateUserData() {
        RestAssured.filters(new AllureRestAssured());
        UserBody data = new UserBody();
        data.setName("morpheus");
        data.setJob("zion resident");

            UserBody response = step("Update existing user", () ->
                    given()
                    .spec(loginRequestSpecBase)
                    .body(data)
                    .patch("/users/2")
                    .then()
                    .spec(updateExistingUserResponseSpec)
                    .extract().as(UserBody.class));
        step("Check name in response", () ->
            assertEquals(("morpheus"), response.getName()));
        step("Check job in response", () ->
            assertEquals(("zion resident"), response.getJob()));

    }
}
