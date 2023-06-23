package sample.ConnectionDB.Authentication;

import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static sample.ConnectionDB.ConnectedDB.getDBConnection;


public class AuthForLogin {
    static String nameUser;
    static ResultSet resultSetForLogin;
    private static Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public static boolean checkLogin(String login) throws Exception {
        nameUser = login;
        String insert = "SELECT login FROM users WHERE login=?";
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(insert);
        preparedStatement.setString(1, nameUser);
        resultSetForLogin = preparedStatement.executeQuery();
        if (resultSetForLogin.next()) {
            if ((resultSetForLogin.getString("login")).equals(nameUser)) {
                // User.setNameUser(nameUser);
                return true;
            } else {
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("User with this login does not exist, please register!");
                alert.showAndWait();
            }
        }
        return false;
    }
}
