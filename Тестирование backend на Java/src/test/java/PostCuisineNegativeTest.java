import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class PostCuisineNegativeTest {

    private final String apiKey = "62e8122bf46941569505d78f6d632a72";

    @Test
    void firstNegativeTest() {
        given()
                .when()
                .queryParam("apiKey", "apiKey")
                .queryParam("language", "en")
                .formParam("title","Pork roast with green beans")
                .formParam("ingredientList","")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(401)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void secondNegativeTest() {
        given()
                .when()
                .queryParam("apiKey", "apiKey")
                .formParam("title","Pork roast with green beans")
                .formParam("ingredientList","3 oz pork shoulder")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(401)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
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
                .statusCode(401)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void fourthNegativeTest() {
        given()
                .when()
                .queryParam("apiKey", "apiKey")
                .formParam("title", "Pizza 3 cheese")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }
}
