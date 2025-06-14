package ro.ase.grupa1094;

import java.io.Serializable;

public class LoginInfo implements Serializable {
    private String id;
    private String username;
    private String password;

    public LoginInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginInfo:" + username + '\'' + password + '\'';
    }
}
