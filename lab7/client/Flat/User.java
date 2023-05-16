package Flat;

public class User {
    private static String nameUser;
    private static String password;

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getNameUser() {
        return nameUser;
    }

    public static void setNameUser(String nameUsers) {
        nameUser = nameUsers;
    }
    @Override
    public String toString() {
        String tab = "  ".repeat(2);
        return  "\n"
                + tab + "nameUser: " + nameUser;
    }
}
