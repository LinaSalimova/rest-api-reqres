package tests;

import models.CreateUserBody;
import models.CreateUserResponse;
import models.UserBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.*;

public class CreatedUserDataTest extends TestBase {
    @DisplayName("You can create user with success fields name and job")
    @Tags({@Tag("create"), @Tag("user")})
    @Test
    void successCreateUser() {
        String userName = "Lina";
        String userJob = "tester";

        UserBody createdUserData = new UserBody();
        createdUserData.setName(userName);
        createdUserData.setJob(userJob);


        CreateUserResponse response = step("Verify created user data", () ->
                given()
                        .spec(loginRequestSpecBase)
                        .body(createdUserData)
                        .post("/users")
                        .then()
                        .spec(createUserResponseSpec)
                        .extract().as(CreateUserResponse.class));
        step("Check name in response", () ->
                assertEquals(userName, response.getName()));

        step("Check job in response", () ->
                assertEquals(userJob, response.getJob()));
    }

    @Test
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
