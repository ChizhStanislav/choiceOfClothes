package main.java.ru.leverx.choiceOfClothes.dto;

import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
public class ClothesDto {

    private Long id;
    private String name;
    private String temperatureName;
}
