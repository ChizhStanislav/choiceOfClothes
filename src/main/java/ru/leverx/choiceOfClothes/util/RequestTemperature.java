package main.java.ru.leverx.choiceOfClothes.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import main.java.ru.leverx.choiceOfClothes.exception.NotConnectionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import static java.lang.String.format;


@Log4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestTemperature {

    private static final RequestTemperature INSTANCE = new RequestTemperature();

    public Integer getTemperature(String city) {

        try {
            URL obj = new URL(format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=49398b4664b6cdb996ca287dbb7fa534&units=metric&lang=ru", city));

            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line = in.readLine();
                return  JsonParser.parse(line);
            }
        } catch (IOException e) {
            throw new NotConnectionException("Not connection with weather API");
        }
    }

    public static RequestTemperature getInstance() {
        return INSTANCE;
    }
}
