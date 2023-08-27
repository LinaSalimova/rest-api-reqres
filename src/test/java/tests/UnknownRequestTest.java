package tests;

import models.BadRequestResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;


import static specs.Specs.requestSpec;
import static specs.Specs.response404Spec;

public class UnknownRequestTest {
    @Tags({@Tag("unknown"), @Tag("user")})
    @Test
    @DisplayName("Checking for sending an unknown request")
    void unknownRequestTest() {
        BadRequestResponse response = step("Make the request", () -> given(requestSpec)
                .when()
                .get("unknown/23")
                .then()
                .spec(response404Spec)
                .extract().as(BadRequestResponse.class));

        step("Check the error in the response", () -> {
            assertThat(response.getError()).isNull();
        });
    }

}


