import java.sql.*;

import service.CreateService;

public class Conexao {

    public static void main(String[] args) {
    try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:3000/jdbcbd",
                    "neondb_owner","npg_3WvB7VbCRGZx&ssl");
            System.out.println("conexão com sucesso!");
            criarRegistro(connection, "PLM4");
            lerRegistros(connection);
            atualizarRegistro(connection, 0, "Pedro");
            deletarRegistro(connection, 1);
            connection.close();

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao Banco de Dados: " + e.getMessage());
        }

    }

    public static void lerRegistros(Connection connection) throws SQLException {
        String sql = "SELECT * FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Registros:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Nome: " + resultSet.getString("nome"));
            }
        }
    }
    public static void atualizarRegistro(Connection connection, int id, String nome) throws SQLException {
        String sql = "UPDATE users SET nome = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Registro atualizado com sucesso!");
        }
    }
    public static void deletarRegistro(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Registro deletado com sucesso!");
        }
    }
}