package sample.ConnectionDB.Authentication;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static sample.ConnectionDB.ConnectedDB.getDBConnection;


public class AuthForPassword {
    static String password;
    static ResultSet resultSetForPassword;
    static byte[]bytes;
    public static boolean checkPassword(String password, String login)throws Exception{
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        bytes = sha1.digest(password.getBytes());
        password = new String(bytes, "UTF-8");
        String insertForPassword = "SELECT password FROM users WHERE login=?";
        PreparedStatement preparedStatement1 = getDBConnection().prepareStatement(insertForPassword);
        preparedStatement1.setString(1, login);
        resultSetForPassword = preparedStatement1.executeQuery();
        if (resultSetForPassword.next()) {
            if ((resultSetForPassword.getString("password")).equals(password)) {
                return true;
               // User.setPassword(password);
//                System.out.println("Вход успешный!");
//                ClientWork.connectToServer();
            }
        }
        return false;
    }
}
