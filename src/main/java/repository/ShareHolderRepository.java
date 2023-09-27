package repository;

import connection.JdbcConnection;
import model.ShareHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class ShareHolderRepository {
    private Connection connection;

    public ShareHolderRepository(Connection connection) {
        this.connection = connection;
    }

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

    public int edit(ShareHolder updatedShareHolder) throws SQLException {
        String edit = "UPDATE shareHolder SET nameOfShareHolder=?, phoneNumber=?, nationalCode=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setString(1, updatedShareHolder.getNameOfShareHolder());
        preparedStatement.setString(2, updatedShareHolder.getPhoneNumber());
        preparedStatement.setString(3, updatedShareHolder.getNationalCode());
        preparedStatement.setInt(4, updatedShareHolder.getId());
        return preparedStatement.executeUpdate();
    }


    public boolean exist(int id) throws SQLException {
        String exist = "SELECT 1 FROM shareHolder WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(exist);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

}

