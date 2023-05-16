package AuthorizationClient.Authentication;

import AuthorizationClient.Config;
import Client.ClientWork;
import Flat.User;
import Launcher.ClientLauncher;

import java.io.Console;
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
//            Console console = System.console();
//            char[] passwordArray = console.readPassword();
//            String password = new String(passwordArray);
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
                    User.setPassword(password);
                    System.out.println("Вход успешный!");
                    ClientWork.connectToServer();
                }else{
                    System.out.println("Неверный пароль!");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
