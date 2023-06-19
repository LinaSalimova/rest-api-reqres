package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class Specs {
        public static RequestSpecification loginRequestSpecBase = with()
                .log().uri()
                .log().body()
                .filter(withCustomTemplates())
                .contentType(JSON);

        public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(200)
                .expectBody("token", notNullValue())
                .build();

        public static ResponseSpecification  createUserResponseSpec = new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(201)
                .expectBody("id", notNullValue())
                .build();

        public static ResponseSpecification  userWithEmptyFieldsResponseSpec = new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(201)
                .expectBody("name", is(""))
                .expectBody("job", is(""))
                .expectBody("id", notNullValue())
                .build();

        public static ResponseSpecification updateExistingUserResponseSpec = new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(200)
                .expectBody("name", is("morpheus"))
                .expectBody("job", is("zion resident"))
                .expectBody("updatedAt", notNullValue())
                .build();

        public static ResponseSpecification    getUserIdResponseSpec = new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(200)
                .expectBody("data.first_name", is("Tobias"))
                .build();
}

