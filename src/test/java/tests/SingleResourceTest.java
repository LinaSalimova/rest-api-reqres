package tests;

import models.ResourceModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.loginRequestSpecBase;
import static specs.Specs.response200Spec;

public class SingleResourceTest {
    @Test
    @DisplayName("Получение данных о ресурсе")
    void testSingleResource() {
        ResourceModel response = step("Make request", () ->
                given()
                        .spec(loginRequestSpecBase)
                        .when()
                        .get("/unknown/2")
                        .then()
                        .spec(response200Spec)
                        .body(matchesJsonSchemaInClasspath("apischemes/getSingleResource.json"))
                        .extract().as(ResourceModel.class));
        step("Check response", () -> {
            assertEquals(2, response.getData().getId());
            assertEquals("fuchsia rose", response.getData().getName());
        });
    }
}
