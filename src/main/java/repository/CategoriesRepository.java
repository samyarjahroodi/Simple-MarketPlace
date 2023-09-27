package repository;

import connection.JdbcConnection;
import jdk.jshell.spi.SPIResolutionException;
import model.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class CategoriesRepository {
    private final Connection connection;

    public CategoriesRepository(Connection connection) {
        this.connection = connection;
    }

    public int add(Categories categories) throws SQLException {
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

    public int edit(Categories categories) throws SQLException {
        String edit = "UPDATE categories set nameOfCategories=?,description=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setString(1, categories.getNameOfCategories());
        preparedStatement.setString(2, categories.getDescription());
        preparedStatement.setInt(3, categories.getId());
        return preparedStatement.executeUpdate();
    }

    public boolean exist(int id) throws SQLException {
        String exist = "SELECT 1 FROM categories WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(exist);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public void show() throws SQLException {
        String show = "SELECT  nameOfCategories,id from categories";
        PreparedStatement preparedStatement = connection.prepareStatement(show);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nameOfBrand = resultSet.getString("nameOfCategories");
            System.out.println("Category ID: " + id);
            System.out.println("Name of Category: " + nameOfBrand);
        }
    }
}
