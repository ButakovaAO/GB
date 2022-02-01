import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        String cityName = "London";
        String cityId = RequestSender.sendCityIdRequest(cityName);
        Weather weather = new Weather(RequestSender.getCityName(cityName), WeatherResponse.getLocalDate(cityId), null, WeatherResponse.getTemperature(cityId));

        BdHandler bdHandler = new BdHandler();
        bdHandler.addWeather(weather);

        System.out.println(bdHandler.selectAllWeather());
    }

}
