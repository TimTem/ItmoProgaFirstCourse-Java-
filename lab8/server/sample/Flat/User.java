package sample.Flat;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 5362525032286294813L;
    private String nameUser;
    private String password;

    public User(String nameUser, String password) {
        this.nameUser = nameUser;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameUser(){
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @Override
    public String toString() {
        String tab = "  ".repeat(2);
        return  "\n"
                + tab + "nameUser: " + nameUser;
    }
}