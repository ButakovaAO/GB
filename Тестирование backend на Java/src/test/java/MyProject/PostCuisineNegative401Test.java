package MyProject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostCuisineNegative401Test {

    ResponseSpecification responseSpecification = null;
    RequestSpecification requestSpecification = null;
    private final String apiKey = "62e8122bf46941569505d78f6d632a72";

    @BeforeEach
    void beforeTest() {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(401)
                .expectStatusLine("HTTP/1.1 401 Unauthorized")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();

        RestAssured.responseSpecification = responseSpecification;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", "apiKey")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    @Test
    void firstNegativeTest() {
        given().spec(requestSpecification)
                .when()
                .queryParam("language", "en")
                .formParam("title","Pork roast with green beans")
                .formParam("ingredientList","")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void secondNegativeTest() {
        given().spec(requestSpecification)
                .when()
                .formParam("title","Pork roast with green beans")
                .formParam("ingredientList","3 oz pork shoulder")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void thirdNegativeTest() {
        given()
                .when()
                .queryParam("apiKey", "ba63090b345c45e8afe9497c7ae33427")
                .formParam("title","Pork roast with green beans")
                .formParam("ingredientList","3 oz pork shoulder")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void fourthNegativeTest() {
        given().spec(requestSpecification)
                .when()
                .formParam("title", "Pizza 3 cheese")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .spec(responseSpecification);
    }
}
