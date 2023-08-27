package tests;

import models.CreateUserBody;
import models.CreateUserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specs.*;
import static specs.Specs.response204Spec;

public class CheckAndDeletingUser {

    @Test
    @Tags({@Tag("check"), @Tag("user")})
    @DisplayName("Check user creation")
    void createUserTest() {
        String userName = "Lina";
        String userJob = "tester";

        CreateUserBody requestBody = new CreateUserBody();
        requestBody.setName(userName);
        requestBody.setJob(userJob);

        CreateUserResponse response = step("Make a request", () -> given(requestSpec)
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .spec(response201Spec)
                .extract().as(CreateUserResponse.class));

        step("Check user name in response", () ->
                assertThat(response.getName()).isEqualTo(userName));

        step("Check user ID in response", () ->
                assertThat(response.getId()).isNotNull());
    }
    @Tags({@Tag("deleting"), @Tag("user")})
    @Test
    @DisplayName("Deleting a user")
    void testDeleteUser() {
        step("Make request", () ->
                given()
                        .spec(loginRequestSpecBase)
                        .when()
                        .delete("/users/2")
                        .then()
                        .spec(response204Spec));
    }

}

