package main.java.ru.leverx.choiceOfClothes.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonParser {

    public static Integer parse(String json) {
        String jsonPath = "\"temp\":";
        json = json.substring(json.indexOf(jsonPath) + jsonPath.length());
        double result = Double.parseDouble(json.substring(0, json.indexOf(",")));
        return (int) result;
    }
}
