package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "1381Iran");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JdbcConnection() throws SQLException {
    }

    public JdbcConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public static Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
