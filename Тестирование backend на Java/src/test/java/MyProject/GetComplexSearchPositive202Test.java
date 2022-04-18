package MyProject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetComplexSearchPositive202Test {

    ResponseSpecification responseSpecification = null;
    RequestSpecification requestSpecification = null;
    private final String apiKey = "62e8122bf46941569505d78f6d632a72";

    @BeforeEach
    void beforeTest() {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();

        RestAssured.responseSpecification = responseSpecification;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    @Test
    void firstPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("query", "pasta")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void secondPositiveTest() {
        JsonPath response = given().spec(requestSpecification)
                .queryParam("query", "apple")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("results.title[0]"), equalTo("Apple Cake"));
    }

    @Test
    void thirdPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("diet", "ketogenic")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void fourthPositiveTest() {
        JsonPath response = given().spec(requestSpecification)
                .queryParam("cuisine", "Indian,Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("results.title[3]"), equalTo("Simple Skillet Lasagna"));
    }

    @Test
    void fifthPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("ignorePantry", true)
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void sixthPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("addRecipeNutrition", true)
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void seventhPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("includeIngredients", "tomatoes")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void eighthPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("query", "pizza")
                .queryParam("cuisine", "American")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void ninthPositiveTest() {
        JsonPath response = given().spec(requestSpecification)
                .queryParam("query", "!@%23")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("totalResults"), equalTo(0));
    }

    @Test
    void tenthPositiveTest() {
        JsonPath response = given().spec(requestSpecification)
                .queryParam("query", "25546568522")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("totalResults"), equalTo(0));
    }

    @Test
    void eleventhPositiveTest() {
        JsonPath response = given().spec(requestSpecification)
                .queryParam("query", "07.04.2022")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("totalResults"), equalTo(0));
    }

    @Test
    void twelfthPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("query", "pasta")
                .queryParam("diet", "vegetarian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void thirteenPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("query", "pasta")
                .queryParam("intolerances", "gluten")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void fourteenPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("type", "dessert")
                .queryParam("cuisines", "Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void fifteenPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("type", "dessert")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void sixteenPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("type", "dessert")
                .queryParam("maxCalories", 300)
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void seventeenPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("sort", "popularity")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void eighteenthPositiveTest() {
        JsonPath response = given().spec(requestSpecification)
                .queryParam("query", "apple")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("results.title[1]"), equalTo("Apple Crumble"));
    }

    @Test
    void nineteenthPositiveTest() {
        JsonPath response = given().spec(requestSpecification)
                .queryParam("intolerances", "Dairy,Egg,Gluten,Grain,Peanut,Seafood,Sesame,Shellfish,Soy,Sulfite,Tree Nut,Wheat")
                .queryParam("cuisine", "Indian,Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("results.title[0]"), equalTo("Gujarati Dry Mung Bean Curry"));
    }

    @Test
    void twentiethPositiveTest() {
        JsonPath response = given().spec(requestSpecification)
                .queryParam("query", "Egg")
                .queryParam("intolerances", "Dairy,Egg,Gluten,Grain,Peanut,Seafood,Sesame,Shellfish,Soy,Sulfite,Tree Nut,Wheat")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification)
                .extract()
                .jsonPath()
                .prettyPeek();
        assertThat(response.get("totalResults"), equalTo(0));
    }

    @Test
    void twentyFirstPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("query", "burger")
                .queryParam("minCalories", 50)
                .queryParam("maxCalories", 800)
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }
}
