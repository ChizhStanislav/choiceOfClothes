package main.java.ru.leverx.choiceOfClothes.service;

import lombok.*;
import main.java.ru.leverx.choiceOfClothes.dictonary.Role;
import main.java.ru.leverx.choiceOfClothes.dto.UserDto;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();
    private static final Map<Pair<String, String>, UserDto> USERS = new HashMap<>() {
        {
            put(Pair.of("admin", "5529"), UserDto.builder()
                    .id(1L)
                    .role(Role.ADMIN)
                    .build());
        }
    };

    public Optional<UserDto> login(String username, String password) {
        return Optional.ofNullable(USERS.get(Pair.of(username,password)));
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "of")
    @Builder
    public static class Pair<F, S> {
        private F first;
        private S second;
    }
}
