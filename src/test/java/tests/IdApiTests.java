package tests;

import io.qameta.allure.Owner;
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
import static specs.Specs.getUserIdResponseSpec;
import static specs.Specs.loginRequestSpecBase;

public class IdApiTests {
    @DisplayName("You can get existing user via his system id")
    @Tags({@Tag("user"), @Tag("id")})
    @Owner(value = "Alekseeva Lina")
    @Test
    void getExistUserById() {
        RestAssured.filters(new AllureRestAssured());
        UserBody data = new UserBody();
        data.getName();
        step("Get existing user via his system id", () -> {
            UserBody response = given()
                    .spec(loginRequestSpecBase)
                    .get("/users/9")
                    .then()
                    .spec(getUserIdResponseSpec)
                    .extract().as(UserBody.class);
            step("Check response", () ->
                    assertEquals(("Tobias"), response.getName()));
        });

    }
}
