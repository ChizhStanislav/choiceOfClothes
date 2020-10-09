package main.java.ru.leverx.choiceOfClothes.dictonary;

import lombok.Getter;

@Getter
public enum Temperature {

    COLDLY(10,-1000),
    COMFORT(20,11),
    HOT(1000,21);

    private final Integer minimumTemperature;
    private final Integer maximumTemperature;

    Temperature(Integer maximumTemperature, Integer minimumTemperature){
        this.maximumTemperature = maximumTemperature;
        this.minimumTemperature = minimumTemperature;
    }

}
