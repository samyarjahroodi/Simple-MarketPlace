package service;

import model.Users;
import repository.UsersRepository;
import validation.Validation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsersService {
    UsersRepository usersRepository = new UsersRepository();
    Validation validation = new Validation();
    Scanner scanner = new Scanner(System.in);

    public UsersService() throws SQLException {
    }

    public void register() throws SQLException {
        Users users = new Users();
        System.out.println("Enter your firstname");
        users.setNameOfUsers(scanner.next());
        System.out.println("Enter your username");
        users.setUsername(scanner.next());
        System.out.println("Enter your email");
        users.setEmail(validation.isValidEmail());
        System.out.println("Enter your password");
        users.setPasswordOfUsers(validation.isValidPasswordForRegistration());
        int result = usersRepository.saveUser(users);
        if (result != 0) {
            System.out.println("SUCCESSFULLY ADDED TO THE DATABASE");
        } else {
            System.out.println("THERE IS A PROBLEM");
        }
    }

    public boolean login() throws SQLException {
        Users users = new Users();
        boolean usernameExists = false;

        while (!usernameExists) {
            System.out.println("Enter your username");
            String username = scanner.next();
            usernameExists = usersRepository.doesUserExist(username);

            if (usernameExists) {
                System.out.println("YOUR USERNAME EXISTS");
                users.setUsername(username); // Set the username in the Users object
            } else {
                System.out.println("THERE IS NO MATCH IN DATABASE");
            }
        }

        System.out.println("Enter your password");
        users.setPasswordOfUsers(scanner.next());
        boolean loginSuccessful = usersRepository.login(users);

        if (loginSuccessful) {
            System.out.println("SUCCESSFULLY LOGGED IN");
        } else {
            System.out.println("THERE IS A PROBLEM WITH EITHER YOUR USERNAME OR PASSWORD");
            System.exit(0);
        }

        return true;
    }
}