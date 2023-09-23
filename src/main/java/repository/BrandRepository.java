package repository;

import connection.JdbcConnection;
import model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class BrandRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public BrandRepository() throws SQLException {
    }

    public int save(Brand brand) throws SQLException {
        String insert = "INSERT INTO brand(nameOfBrand,website,description)values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, brand.getNameOfBrand());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());
        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String delete = "DELETE FROM brand where id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    public int edit(int id) throws SQLException {
        String edit = "UPDATE brand set nameOfBrand=?,website=?,description=? where id=? ";
        Brand brand = new Brand();
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setString(1, brand.getNameOfBrand());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());
        preparedStatement.setInt(4, id);
        return preparedStatement.executeUpdate();
    }
}
