package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadService {
    public void lerRegistros(Connection connection) throws SQLException {
        String sql = "SELECT * FROM registros";
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Registros:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Nome: " + resultSet.getString("nome"));
            }
        }
    }
}
