package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/crudJPA"; // JDBC
    private static final String USUARIO = "neondb_owner";
    private static final String SENHA = "npg_3WvB7VbCRGZx";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
