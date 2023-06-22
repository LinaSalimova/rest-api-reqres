package tests;


import io.qameta.allure.Owner;
import models.GetListUsersModel;
import models.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.Specs.loginRequestSpecBase;
import static specs.Specs.userIdCheckResponseSpec;

public class MassiveModel extends TestBase {
    @DisplayName("Model for object with array")
    @Tags({@Tag("massive"), @Tag("model")})
    @Owner(value = "Alekseeva Lina")
    @Test
    void successfulGetListOfUsersIdTest() {

        Integer[] userId = {7, 8, 9, 10, 11, 12};

        GetListUsersModel response = step("Make request", () ->
                given()
                        .spec(loginRequestSpecBase)
                        .when()
                        .get("/users?page=2")
                        .then()
                        .spec(userIdCheckResponseSpec)
                        .extract().as(GetListUsersModel.class));

        HashSet<Integer> idsFromResponse = new HashSet<>();
        LinkedList<UserModel> usersFromResponse = response.getData();

        for (UserModel user : usersFromResponse) {
            idsFromResponse.add(user.getId());
        }

        step("Check response", () -> {
            for (int id : userId) {
                assertTrue(idsFromResponse.contains(id));
            }
            assertEquals(idsFromResponse.size(), userId.length);
        });
    }
}