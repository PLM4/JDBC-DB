package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateService {

    public void criarRegistro(Connection connection, String nome) throws SQLException {
        String sql = "INSERT INTO registros (nome) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.executeUpdate();
            System.out.println("Registro criado com sucesso!");
        }
    }

}
