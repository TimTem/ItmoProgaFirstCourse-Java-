package AuthorizationClient;

import Flat.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static AuthorizationClient.ConnectedToBD.getDBConnection;

public class ClassForAutentification {
    private static ResultSet resultSet;
    public static void autentificationForChekUser(){
       try {
           PreparedStatement preparedStatement = getDBConnection().prepareStatement("SELECT * FROM users WHERE login = ?;");
           preparedStatement.setString(1, User.getNameUser());
           resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               if(resultSet.getString("login").equals(User.getNameUser()) && resultSet.getString("password").equals(User.getPassword())){
                   System.out.println("Аутентификация пройдена можете продолжать работу!");
               }else{
                   System.out.println("Аутентификация не была пройдена! Мы сомневаемся, что это вы!");
                   System.exit(1);
               }
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
    }
}
