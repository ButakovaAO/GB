import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.function.ToDoubleFunction;

public class WeatherResponse {

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String ARI_KEY = "zB2f6SkNXr5sxED5ygWr0jg3tGu3EmYz";


    static public String getLocalDate(String cityId) throws IOException {
        String localDateOut;

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

        JsonNode dateWeather = objectMapper
                .readTree(responseJson)
                .at("/DailyForecasts/0/Date");

        localDateOut = dateWeather.asText();
        return localDateOut;
    }


    static public Double getTemperature(String cityId) throws IOException {
        Double temperatureOut;

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

        JsonNode TemperatureValue = objectMapper
                .readTree(responseJson)
                .at("/DailyForecasts/0/Temperature/Minimum/Value");

        temperatureOut = Double.parseDouble(TemperatureValue.asText());
        return temperatureOut;
    }

}
