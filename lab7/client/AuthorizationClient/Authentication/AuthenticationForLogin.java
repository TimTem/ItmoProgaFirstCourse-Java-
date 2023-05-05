package AuthorizationClient.Authentication;

import Flat.User;
import Launcher.ClientLauncher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static AuthorizationClient.ConnectedToBD.getDBConnection;

public class AuthenticationForLogin {
    static String nameUser;
    static ResultSet resultSetForLogin;
    public static void authentication(){
        try {
            System.out.println("Введите ваше имя пользователя!");
            Scanner scanner = new Scanner(System.in);
            nameUser = scanner.nextLine();
            String insert = "SELECT login FROM users WHERE login=?";
            PreparedStatement preparedStatement = getDBConnection().prepareStatement(insert);
            preparedStatement.setString(1, nameUser);
            resultSetForLogin = preparedStatement.executeQuery();
//            if(resultSetForLogin.next() == false){
//                System.out.println("Пользователь с таким логином не существует, пожалуйста зарегистрируйтесь!");
//                return;
//            }
            if (resultSetForLogin.next()) {
                if ((resultSetForLogin.getString("login")).equals(nameUser)) {
                    User.setNameUser(nameUser);
                    AuthenticationForPassword.authentication();
                }
            }else{
                System.out.println("Пользователя с таким логином не существует, пожалуйста зарегистрируйтесь!");
            }
        }catch (Exception e){
            System.out.println("Пользователь с таким логином не существует, пожалуйста зарегистрируйтесь!");
        }
    }
    public static String getNameUser() {
        return nameUser;
    }
}
