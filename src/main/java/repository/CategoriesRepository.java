package repository;

import connection.JdbcConnection;
import model.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriesRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public CategoriesRepository() throws SQLException {
    }

    public int add() throws SQLException {
        Categories categories = new Categories();
        String add = "INSERT INTO categories(nameOfCategories,description)values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1, categories.getNameOfCategories());
        preparedStatement.setString(2, categories.getDescription());
        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String delete = "DELETE FROM categories WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    public int edit(int id) throws SQLException {
        Categories categories = new Categories();
        String edit = "UPDATE categories set nameOfCategories=?,description=?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setString(1, categories.getNameOfCategories());
        preparedStatement.setString(2, categories.getDescription());
        return preparedStatement.executeUpdate();
    }
}
