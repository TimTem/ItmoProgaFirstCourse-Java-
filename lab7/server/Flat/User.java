package Flat;

public class User {
    private static String nameUser;

    public  User(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser1) {
        nameUser = nameUser1;
    }
    @Override
    public String toString() {
        String tab = "  ".repeat(2);
        return  "\n"
                + tab + "nameUser: " + nameUser;
    }
}
