package tests;

import io.qameta.allure.Owner;

import models.Login;
import models.LoginResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.*;


public class AuthApiTest extends TestBase {
    @Tags({@Tag("api"), @Tag("auth")})
    @Owner(value = "Alekseeva Lina")
    @Test
    void successLogin() {

        Login data = new Login();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");
        LoginResponse response = step("Verify registration token", () ->
                given()
                        .spec(loginRequestSpecBase)
                        .body(data)
                        .post("/login")
                        .then()
                        .spec(loginResponseSpec)
                        .extract().as(LoginResponse.class));
        step("Check response", () ->
                assertEquals(("QpwL5tke4Pnpja7X4"), response.getToken()));
    }
}
