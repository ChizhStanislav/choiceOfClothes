package main.java.ru.leverx.choiceOfClothes.dto;

import lombok.*;
import main.java.ru.leverx.choiceOfClothes.dictonary.Role;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private Role role;
}
