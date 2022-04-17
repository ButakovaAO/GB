import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetComplexSearchPositiveTest {

    private final String apiKey = "62e8122bf46941569505d78f6d632a72";

    @Test
    void firstPositiveTest() {
        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "apple")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("results.title[1]"), equalTo("Apple Crumble"));
    }

    @Test
    void secondPositiveTest() {
        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("intolerances", "Dairy,Egg,Gluten,Grain,Peanut,Seafood,Sesame,Shellfish,Soy,Sulfite,Tree Nut,Wheat")
                .queryParam("cuisine", "Indian,Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("results.title[0]"), equalTo("Gujarati Dry Mung Bean Curry"));
    }

    @Test
    void thirdPositiveTest() {
        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "Egg")
                .queryParam("intolerances", "Dairy,Egg,Gluten,Grain,Peanut,Seafood,Sesame,Shellfish,Soy,Sulfite,Tree Nut,Wheat")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("totalResults"), equalTo(0));
    }

    @Test
    void fourthPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "burger")
                .queryParam("minCalories", 50)
                .queryParam("maxCalories", 800)
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void fifthPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("ignorePantry", true)
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void sixthPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("addRecipeNutrition", true)
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void seventhPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("includeIngredients", "tomatoes")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void eighthPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "pizza")
                .queryParam("cuisine", "American")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void ninthPositiveTest() {
        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "!@%23")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("totalResults"), equalTo(0));
    }

    @Test
    void tenthPositiveTest() {
        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "25546568522")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("totalResults"), equalTo(0));
    }

    @Test
    void eleventhPositiveTest() {
        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "07.04.2022")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("totalResults"), equalTo(0));
    }

    @Test
    void twelfthPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "pasta")
                .queryParam("diet", "vegetarian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void thirteenPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "pasta")
                .queryParam("intolerances", "gluten")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void fourteenPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("type", "dessert")
                .queryParam("cuisines", "Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void fifteenPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("type", "dessert")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void sixteenPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("type", "dessert")
                .queryParam("maxCalories", 300)
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void seventeenPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("sort", "popularity")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }
}
