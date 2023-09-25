package repository;

import connection.JdbcConnection;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public UsersRepository() throws SQLException {
    }

    public int saveUser(Users users) throws SQLException {
        String insert = "INSERT INTO users(nameOfUsers,username,email,passwordOfUsers) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, users.getNameOfUsers());
        preparedStatement.setString(2, users.getUsername());
        preparedStatement.setString(3, users.getEmail());
        preparedStatement.setString(4, users.getPasswordOfUsers());
        return preparedStatement.executeUpdate();
    }

    public boolean login(Users users) throws SQLException {
        String checkUsers = "SELECT * FROM users WHERE username=? AND passwordOfUsers=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(checkUsers);
        preparedStatement.setString(1, users.getUsername());
        preparedStatement.setString(2, users.getPasswordOfUsers());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public boolean doesUserExist(String username) throws SQLException {
        String checkUsername = "SELECT * from users where username = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(checkUsername);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
