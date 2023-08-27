package tests;


import models.UserUpdate;
import models.UserUpdateResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.*;

public class UsersApiTest extends TestBase {
    String userName = "morpheus";
    String userJob = "zion resident";


    @DisplayName("You can update existing user")
    @Tags({@Tag("update"), @Tag("user")})
    @Test
    void updateUserData() {
        UserUpdate requestBody = new UserUpdate();
        requestBody.setName(userName);
        requestBody.setJob(userJob);

        UserUpdateResponse response = step("Update existing user", () ->
                given()
                        .spec(loginRequestSpecBase)
                        .body(requestBody)
                        .when()
                        .put("/users/2")
                        .then()
                        .spec(updateExistingUserResponseSpec)
                        .extract().as(UserUpdateResponse.class));
        step("Check name in response", () ->
                assertEquals(userName, response.getName()));
        step("Check job in response", () ->
                assertEquals(userJob, response.getJob()));

    }
}
