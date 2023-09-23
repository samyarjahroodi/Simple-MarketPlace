package repository;

import connection.JdbcConnection;
import model.ShareHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class ShareHolderRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public ShareHolderRepository() throws SQLException {
    }

    public int save(ShareHolder shareHolder) throws SQLException {
        String insert = "INSERT INTO shareHolder(nameOfShareHolder,phoneNumber,nationalCode)values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, shareHolder.getNameOfShareHolder());
        preparedStatement.setString(2, shareHolder.getPhoneNumber());
        preparedStatement.setString(3, shareHolder.getNationalCode());
        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String delete = "DELETE FROM shareHolder where id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    public int edit(int id) throws SQLException {
        String edit = "UPDATE brand set nameOfShareHolder=?,phoneNumber=?,nationalCode=? where id=? ";
        ShareHolder shareHolder = new ShareHolder();
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setString(1, shareHolder.getNameOfShareHolder());
        preparedStatement.setString(2, shareHolder.getPhoneNumber());
        preparedStatement.setString(3, shareHolder.getNationalCode());
        preparedStatement.setInt(4, id);
        return preparedStatement.executeUpdate();
    }
}

