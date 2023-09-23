package repository;

import connection.JdbcConnection;
import model.Brand;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class ProductRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public ProductRepository() throws SQLException {
    }

    public int save(Product product) throws SQLException {
        String add = "INSERT INTO product(nameOfProduct,createDate,categoriesId,brandId) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1, product.getNameOfProduct());
        preparedStatement.setString(2, product.getCreateDate());
        preparedStatement.setInt(3, product.getCategoriesId());
        preparedStatement.setInt(1, product.getBrandId());
        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String delete = "DELETE FROM product where id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    public int edit(int id) throws SQLException {
        String edit = "UPDATE product set nameOfProduct=?,createDate=?,categoriesID=?,brandID=? where id=? ";
        Product product = new Product();
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setString(1, product.getNameOfProduct());
        preparedStatement.setString(2, product.getCreateDate());
        preparedStatement.setInt(3, product.getCategoriesId());
        preparedStatement.setInt(4, product.getBrandId());
        preparedStatement.setInt(5, id);
        return preparedStatement.executeUpdate();
    }
}
