package sample.ConnectionDB.Registration;

import javafx.scene.control.Alert;
import org.postgresql.util.PSQLException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;

import static sample.ConnectionDB.ConnectedDB.getDBConnection;


public class RegistUser {
    private static String nameUser;
    private static String passwordUser;
    private static byte[] bytes;
    private static Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public static void registUser(String login, String password) throws Exception {
        nameUser = login;
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        bytes = sha1.digest(password.getBytes());
        passwordUser = new String(bytes, "UTF-8");
        String insert = "INSERT INTO users (login,password) VALUES (?,?)";
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(insert);
        preparedStatement.setString(1,nameUser);
        preparedStatement.setString(2,passwordUser);
        try {
            preparedStatement.executeUpdate();
        }catch (PSQLException e){
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("User with this login already exists!");
            alert.showAndWait();
            return;
        }
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("New user added!!");
        alert.showAndWait();
    }
}
