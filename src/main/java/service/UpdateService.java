package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateService {
    public void atualizarRegistro(Connection connection, int id, String nome) throws SQLException {
        String sql = "UPDATE registros SET nome = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Registro atualizado com sucesso!");
        }
    }
}
