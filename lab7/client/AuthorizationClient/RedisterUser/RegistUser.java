package AuthorizationClient.RedisterUser;

import org.postgresql.util.PSQLException;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static AuthorizationClient.ConnectedToBD.getDBConnection;

public class RegistUser {
    static String nameUser;
    static String passwordUser;
    static byte[] bytes;
    public static void registUser() throws Exception {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        System.out.println("Введите имя пользователя: ");
        Scanner scanner = new Scanner(System.in);
        nameUser = scanner.nextLine();
        System.out.println("Введите пароль пользователя: ");
        Scanner scanner1 = new Scanner(System.in);
        String password = scanner1.nextLine();
        bytes = sha1.digest(password.getBytes());
        passwordUser = new String(bytes, "UTF-8");
//        StringBuilder stringBuilder = new StringBuilder();
//        for(byte b : bytes){
//            stringBuilder.append(String.format("%02X", b));
//        }
//        passwordUser = stringBuilder.toString();
        String insert = "INSERT INTO users (login,password) VALUES (?,?)";
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(insert);
        preparedStatement.setString(1,nameUser);
        preparedStatement.setString(2,passwordUser);
        try {
            preparedStatement.executeUpdate();
        }catch (PSQLException e){
            System.out.println("Пользователь с таким логином уже существует!");
            return;
        }
        System.out.println("Добавлен новый пользователь!");
    }
}
