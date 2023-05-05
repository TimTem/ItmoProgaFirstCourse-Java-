package Flat;

public class User {
    private static String nameUser;
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
