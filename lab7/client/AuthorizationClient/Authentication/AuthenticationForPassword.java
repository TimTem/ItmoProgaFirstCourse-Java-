package AuthorizationClient.Authentication;

import Client.ClientWork;
import Launcher.ClientLauncher;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static AuthorizationClient.ConnectedToBD.getDBConnection;

public class AuthenticationForPassword {
    static String password;
    static ResultSet resultSetForPassword;
    static byte[]bytes;
    public static void authentication() {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            System.out.println("Введите пароль: ");
            Scanner scanner1 = new Scanner(System.in);
            password = scanner1.nextLine();
            bytes = sha1.digest(password.getBytes());
            password = new String(bytes, "UTF-8");
            String insertForPassword = "SELECT password FROM users WHERE login=?";
            PreparedStatement preparedStatement1 = getDBConnection().prepareStatement(insertForPassword);
            preparedStatement1.setString(1, AuthenticationForLogin.getNameUser());
            resultSetForPassword = preparedStatement1.executeQuery();
            if (resultSetForPassword.next()) {
                if ((resultSetForPassword.getString("password")).equals(password)) {
                    System.out.println("Вход успешный!");
                    ClientWork.connectToServer();
                }else{
                    System.out.println("ПОШЕЛ НАХУЙ");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
