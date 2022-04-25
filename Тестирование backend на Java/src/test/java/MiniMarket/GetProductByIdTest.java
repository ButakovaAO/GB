package MiniMarket;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GetProductByIdTest {

    static ProductService productService;
    Product product = null;
    Faker faker = new Faker();
    int id;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
    }


    @Test
    void createProduct1Test() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

    @SneakyThrows
    @AfterEach
    void getProductTest() {
        Response<ResponseBody> response = productService.getProducts().execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        Response<Product> response = productService.getProductById(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(id));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));
    }
}



