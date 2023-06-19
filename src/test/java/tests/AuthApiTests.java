package tests;
import io.qameta.allure.Owner;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import models.Login;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.*;


public class AuthApiTests extends TestBase {
    @Tags({@Tag("api"),@Tag("auth")})
    @Owner(value = "Alekseeva Lina")
    @Test
    void successLogin() {
            RestAssured.filters(new AllureRestAssured());
            Login data = new Login();
            data.setEmail("eve.holt@reqres.in");
            data.setPassword("cityslicka");
        step("Verify registration token", () -> {
            Login.LoginResponse response = given()
                    .spec(loginRequestSpecBase)
                    .body(data)
                    .post("/login")
                    .then()
                    .spec(loginResponseSpec)
                    .extract().as(Login.LoginResponse.class);
            step("Check response", () ->
            assertEquals(("QpwL5tke4Pnpja7X4"), response.getToken()));
        });
    }

}
