package main.java.ru.leverx.choiceOfClothes.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspPathUtil {

    public String get(String page) {
        return String.format("/WEB-INF/jsp%s.jsp", page);
    }
}
