import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.AfterEach;
import java.util.concurrent.TimeUnit;

public class ShoppingListTest {

    private final String apiKey = "62e8122bf46941569505d78f6d632a72";

    String id;
    @Test
    void addToShoppingListTest() {
        id = given()
                .queryParam("hash", "a3da66460bfb7e62ea1c96cfa0b7a634a346ccbf")
                .queryParam("apiKey", apiKey)
                .body("{\n"
                        + " \"item\": \"1 package baking powder\",\n"
                        + " \"aisle\": \"Baking\",\n"
                        + " \"parse\": true\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/geekbrains/shopping-list/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();
            }

    @AfterEach
    void tearDown() {
        given()
                .queryParam("hash", "a3da66460bfb7e62ea1c96cfa0b7a634a346ccbf")
                .queryParam("apiKey", apiKey)
                .delete("https://api.spoonacular.com/mealplanner/geekbrains/shopping-list/items" + id)
                .then()
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }
}