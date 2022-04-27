import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CuisineTest {

    private final String apiKey = "62e8122bf46941569505d78f6d632a72";

    @Test
    void firstPositiveTest() {
        given()
                .when()
                .queryParam("apiKey", apiKey)
                .formParam("title","Apple Cake")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void secondPositiveTest() {
        given()
                .when()
                .queryParam("apiKey", apiKey)
                .formParam("title","Apfelkuchen")
                .formParam("language","de")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void thirdPositiveTest() {
        given()
                .when()
                .queryParam("apiKey", apiKey)
                .formParam("title","Turkey Tomato Cheese Pizza")
                .formParam("language","en")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void fourthPositiveTest() {
        given()
                .when()
                .queryParam("apiKey", apiKey)
                .formParam("title","Pork roast with green beans")
                .formParam("ingredientList","3 oz pork shoulder")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void firstNegativeTest() {
        given()
                .when()
                .queryParam("apiKey", 123)
                .formParam("title","Apple Cake")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(401);
    }
}
