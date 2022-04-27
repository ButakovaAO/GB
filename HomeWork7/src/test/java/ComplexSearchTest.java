import org.hamcrest.Matchers;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ComplexSearchTest {

    private final String apiKey = "62e8122bf46941569505d78f6d632a72";

    @Test
    void firstPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "pasta")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L),TimeUnit.SECONDS);
    }

    @Test
    void secondPositiveTest() {
        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "apple")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .body()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("results.title[0]"), equalTo("Apple Cake"));
    }

    @Test
    void thirdPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("diet", "ketogenic")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200);
    }

    @Test
    void fourthPositiveTest() {
        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("cuisine", "Indian,Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .body()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("results.title[3]"), equalTo("Simple Skillet Lasagna"));
    }

    @Test
    void firstNegativeTest() {
        given()
                .queryParam("apiKey", 123)
                .queryParam("excludeCuisine", "greek")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(401);
    }
}
