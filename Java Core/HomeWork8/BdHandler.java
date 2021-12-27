import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;

public class BdHandler {
    private final String PATH_TO_DB = "jdbc:sqlite:src/main/resources/WeatherBD.db";
    private Connection connection;

    public BdHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_TO_DB);
    }

    public void addWeather(Weather weather) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "INSERT INTO weather('city', 'localDate', 'weatherText', 'temperature') VALUES (?, ?, ?, ?)"
        )) {
            preparedStatement.setObject(1, weather.getCity());
            preparedStatement.setObject(2, weather.getLocalDate());
            preparedStatement.setObject(3, weather.getWeatherText());
            preparedStatement.setObject(4, weather.getTemperature());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Weather> selectAllWeather() {
        ArrayList<Weather>  result = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");

            while (resultSet.next()) {
                Weather weather = new Weather(
                        resultSet.getString("city"),
                        resultSet.getString("localDate"),
                        resultSet.getString("weatherText"),
                        resultSet.getDouble("temperature")
                );
                result.add(weather);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
