import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;

public class GetComplexSearchNegativeTest {

    private final String apiKey = "62e8122bf46941569505d78f6d632a72";

    @Test
    void firstNegativeTest() {
        given()
                .queryParam("apiKey", "apiKey")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(401)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void secondNegativeTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("minCarbs", "ten")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(404)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void thirdNegativeTest() {
        given()
                .queryParam("apiKey", "ba63090b345c45e8afe9497c7ae33427")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(401)
                .time(Matchers.lessThan(5L), TimeUnit.SECONDS);
    }
}
