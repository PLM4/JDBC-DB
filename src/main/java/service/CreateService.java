package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateService {
    
        public void criarRegistro(Connection connection, String nome) throws SQLException {
        String sql = "INSERT INTO users (nome) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.executeUpdate();
            System.out.println("Registro criado com sucesso!");
        }
    }

//     try {
//         Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:3000/jdbcbd",
//                 "neondb_owner","npg_3WvB7VbCRGZx&ssl");
//         System.out.println("conexão com sucesso!");
//         criarRegistro(connection, "PLM4");
//         lerRegistros(connection);
//         atualizarRegistro(connection, 0, "Pedro");
//         deletarRegistro(connection, 1);
//         connection.close();

//     } catch (SQLException e) {
//         System.out.println("Erro ao conectar ao Banco de Dados: " + e.getMessage());
//     }

// }


}
