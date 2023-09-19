package model;

public class Users {
    private Integer id;
    private String nameOfUsers;
    private String username;
    private String email;
    private String passwordOfUsers;

    public Users() {
    }

    public Users(Integer id, String nameOfUsers,
                 String username, String email, String passwordOfUsers) {
        this.id = id;
        this.nameOfUsers = nameOfUsers;
        this.username = username;
        this.email = email;
        this.passwordOfUsers = passwordOfUsers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfUsers() {
        return nameOfUsers;
    }

    public void setNameOfUsers(String nameOfUsers) {
        this.nameOfUsers = nameOfUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordOfUsers() {
        return passwordOfUsers;
    }

    public void setPasswordOfUsers(String passwordOfUsers) {
        this.passwordOfUsers = passwordOfUsers;
    }
}
