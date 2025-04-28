package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteService {
    
    public void deletarRegistro(Connection connection, int id) throws SQLException {
    String sql = "DELETE FROM users WHERE id = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);
        statement.executeUpdate();
        System.out.println("Registro deletado com sucesso!");
    }
}
}
