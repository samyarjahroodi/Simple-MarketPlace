package repository;

import connection.JdbcConnection;
import model.ShareHolder;
import model.ShareHolderBrand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class SharHolderBrandRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public SharHolderBrandRepository() throws SQLException {
    }

    public int save(ShareHolderBrand shareHolderBrand) throws SQLException {
        String save = "INSERT INTO shareHolder_brand (shareHolderId,brandId) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(save);
        preparedStatement.setInt(1, shareHolderBrand.getShareHolderId());
        preparedStatement.setInt(2, shareHolderBrand.getBrandId());
        return preparedStatement.executeUpdate();
    }
}