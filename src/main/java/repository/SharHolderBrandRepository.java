package repository;

import connection.JdbcConnection;
import model.ShareHolder;
import model.ShareHolderBrand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class SharHolderBrandRepository {
    private Connection connection;

    public SharHolderBrandRepository(Connection connection) {
        this.connection = connection;
    }

    public int save(ShareHolderBrand shareHolderBrand) throws SQLException {
        String save = "INSERT INTO shareHolder_brand (shareHolderId,brandId) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(save);
        preparedStatement.setInt(1, shareHolderBrand.getShareHolderId());
        preparedStatement.setInt(2, shareHolderBrand.getBrandId());
        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String delete = "DELETE FROM shareHolder_brand where id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    public int edit(ShareHolderBrand shareHolderBrand) throws SQLException {
        String edit = "UPDATE shareHolder_brand SET shareHolderId=?,brandId=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setInt(1, shareHolderBrand.getShareHolderId());
        preparedStatement.setInt(2, shareHolderBrand.getBrandId());
        preparedStatement.setInt(3, shareHolderBrand.getId());
        return preparedStatement.executeUpdate();
    }

    public void show() throws SQLException {

        String show = "SELECT sb.id, b.nameOfBrand, sH.nameOfShareHolder\n" +
                "from shareHolder_brand as sb\n" +
                "         inner join shareHolder sH on sH.id = sb.shareHolderId\n" +
                "         inner join brand b on b.id = sb.brandId;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(show);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String shareHolderName = resultSet.getString("nameOfShareHolder");
                String brandName = resultSet.getString("nameOfBrand");
                System.out.println("ID: " + id);
                System.out.println("ShareHolder Name: " + shareHolderName);
                System.out.println("Brand Name: " + brandName);
                System.out.println();  // Add a blank line for separation
            }
        }
    }

    public boolean exist(int id) throws SQLException {
        String exist = "SELECT 1 FROM shareHolder_brand WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(exist);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

}