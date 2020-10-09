package main.java.ru.leverx.choiceOfClothes.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import java.sql.Connection;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConnectionManager {

    private static DataSource DATA_SOURCE;

    static {
        initConnectionPool();
    }

    private static void initConnectionPool() {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName("org.postgresql.Driver");
        poolProperties.setUrl("jdbc:postgresql://localhost:5432/clothes_list");
        poolProperties.setUsername("postgres");
        poolProperties.setPassword("5529");
        DATA_SOURCE = new DataSource(poolProperties);
    }

    public static Connection get() throws SQLException {
        return DATA_SOURCE.getConnection();
    }
}



