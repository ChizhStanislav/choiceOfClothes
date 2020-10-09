package main.java.ru.leverx.choiceOfClothes.entity;

import lombok.*;
import main.java.ru.leverx.choiceOfClothes.dictonary.Temperature;


@Builder
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Clothes {

    private Long id;
    private String name;
    private Temperature temperature;

}
