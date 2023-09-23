package repository;

import connection.JdbcConnection;
import model.ShareHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class SharHolderBrandRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public SharHolderBrandRepository() throws SQLException {
    }

}
