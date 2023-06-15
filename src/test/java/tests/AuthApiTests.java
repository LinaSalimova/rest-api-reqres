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


public class AuthApiTests extends TestBase {
    @Tags({@Tag("api"),@Tag("auth")})
    @Owner(value = "Alekseeva Lina")
    @Test
    void successLogin() {
        step("Verify registration token", () -> {
            RestAssured.filters(new AllureRestAssured());
            Login data = new Login();
            data.setEmail("eve.holt@reqres.in");
            data.setPassword("cityslicka");

            Login.LoginResponse response = given()
                    .log().uri()
                    .log().body()
                    .contentType(JSON)
                    .body(data)
                    .post("/login")
                    .then()
                    .log().status()
                    .log().body()
                    .statusCode(200)
                    .extract().as(Login.LoginResponse.class);
            assertEquals(("QpwL5tke4Pnpja7X4"), response.getToken());
        });
    }

}
