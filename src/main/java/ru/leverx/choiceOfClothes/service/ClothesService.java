package main.java.ru.leverx.choiceOfClothes.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import main.java.ru.leverx.choiceOfClothes.dao.ClothesDao;
import main.java.ru.leverx.choiceOfClothes.dictonary.Temperature;
import main.java.ru.leverx.choiceOfClothes.dto.ClothesDto;
import main.java.ru.leverx.choiceOfClothes.entity.Clothes;
import main.java.ru.leverx.choiceOfClothes.util.RequestTemperature;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClothesService {

    private static final ClothesService INSTANCE = new ClothesService();

    public static ClothesService getInstance() {
        return INSTANCE;
    }

    public Clothes save(String name, String temperature){
        return ClothesDao.getInstance().save(Clothes.builder()
                .name(name)
                .temperature(Temperature.valueOf(temperature))
                .build());
    }

    public List<ClothesDto> findAllByCity(String city){
        Integer currentTemperature = RequestTemperature.getInstance().getTemperature(city);

        Optional<Temperature> first = Arrays.stream(Temperature.values())
                .filter(temperature -> temperature.getMinimumTemperature() <= currentTemperature && temperature.getMaximumTemperature() >= currentTemperature)
                .findFirst();

        return ClothesDao.getInstance().findAllByTemperature(first.get().name()).stream()
                .map(clothes -> ClothesDto.builder()
                        .id(clothes.getId())
                        .name(clothes.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
