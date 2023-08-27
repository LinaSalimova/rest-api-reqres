package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
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

    public static ResponseSpecification createUserResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .expectBody("id", notNullValue())
            .build();


    public static ResponseSpecification updateExistingUserResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("name", notNullValue())
            .build();

    public static ResponseSpecification userIdCheckResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("data", notNullValue())
            .build();
    public static ResponseSpecification response404Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(404)
            .build();
    public static RequestSpecification requestSpec = with()
            .log().uri()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .baseUri("https://reqres.in")
            .basePath("/api");
    public static ResponseSpecification response201Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .build();
}

