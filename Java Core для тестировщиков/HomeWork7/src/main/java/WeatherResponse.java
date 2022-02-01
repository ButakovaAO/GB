import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class WeatherResponse {

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String ARI_KEY = "zB2f6SkNXr5sxED5ygWr0jg3tGu3EmYz";


    static public String sendTempRequest(String cityId) throws IOException {
        String messageOut;

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", ARI_KEY)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String responseJson = response.body().string();

        JsonNode minTemperatureValue = objectMapper
                .readTree(responseJson)
                .at("/DailyForecasts/0/Temperature/Minimum/Value");

        JsonNode maxTemperatureValue = objectMapper
                .readTree(responseJson)
                .at("/DailyForecasts/0/Temperature/Maximum/Value");

        JsonNode dateWeather = objectMapper
                .readTree(responseJson)
                .at("/DailyForecasts/0/Date");

        messageOut = "На дату "+dateWeather.asText()+ " минимальная температура "+ minTemperatureValue.asText() +"F максимальная температура "+ maxTemperatureValue.asText()+"F.";

        return messageOut;

    }
}
