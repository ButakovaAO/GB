import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class PostCuisinePositiveTest {

    private final String apiKey = "62e8122bf46941569505d78f6d632a72";

    @Test
    void firstPositiveTest() {
        given()
                .when()
                .queryParam("apiKey", apiKey)
                .formParam("title", "Pork roast with green beans")
                .formParam("ingredientList", "3 oz pork shoulder")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void secondPositiveTest() {
        given()
                .when()
                .queryParam("apiKey", apiKey)
                .queryParam("language", "en")
                .formParam("title", "Pork roast with green beans")
                .formParam("ingredientList", "3 oz pork shoulder")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void thirdPositiveTest() {
        given()
                .when()
                .queryParam("apiKey", apiKey)
                .queryParam("language", "en")
                .formParam("title", "Pork roast with green beans")
                .formParam("ingredientList", "")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void fourthPositiveTest() {
        given()
                .when()
                .queryParam("apiKey", apiKey)
                .formParam("title", "Pork roast with green beans")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void fifthPositiveTest() {
        given()
                .when()
                .queryParam("apiKey", apiKey)
                .queryParam("language", "de")
                .formParam("title", "Pork roast with green beans")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void sixthPositiveTest() {
        given()
                .when()
                .queryParam("apiKey", apiKey)
                .formParam("title", "Pizza 3 cheese")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }
}
