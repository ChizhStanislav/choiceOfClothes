package main.java.ru.leverx.choiceOfClothes.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import main.java.ru.leverx.choiceOfClothes.dictonary.Temperature;
import main.java.ru.leverx.choiceOfClothes.entity.Clothes;
import main.java.ru.leverx.choiceOfClothes.util.ConnectionManager;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClothesDao {

    private static final ClothesDao INSTANCE = new ClothesDao();
    private static final String SAVE = "INSERT INTO clothes (name, temperature) VALUES (?, ?)";
    private static final String FIND_ALL_BY_TEMPERATURE = "SELECT id, name, temperature FROM clothes WHERE temperature=?";

    public Clothes save(Clothes clothes) {

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, clothes.getName());
            preparedStatement.setString(2, clothes.getTemperature().name());

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                clothes.setId(generatedKeys.getLong(1));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return clothes;
    }

    public List<Clothes> findAllByTemperature(String temperature) {
        List<Clothes> list = new ArrayList<>();

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_TEMPERATURE)) {
            preparedStatement.setString(1, temperature);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(Clothes.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .temperature(Temperature.valueOf(resultSet.getString("temperature")))
                        .build());
            }


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return list;
    }

    public static ClothesDao getInstance() {
        return INSTANCE;
    }
}
