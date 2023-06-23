package sample.Command.ImplementationCommands;


import sample.Flat.Flat;
import sample.Launcher.StackRunner;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static sample.DesirilizationFromServer.DBConnection.getDBConnection;

public class ImplementationCommandRemoveLast {
    public static void implemenatationRemoveLast(Stack <Flat> flats, ObjectOutputStream out) throws IOException {
        if(flats.size() == 0){
            out.writeObject("Коллекция пуста, команда не может быть использована");
            return;
        }
            try{
                String request = "DELETE FROM flat WHERE id = (SELECT MAX(id) FROM flat)";
                PreparedStatement preparedStatement = getDBConnection().prepareStatement(request);
                preparedStatement.executeUpdate();
               Stack<Flat> reversedStack = new Stack<>();
               reversedStack.addAll(flats);
               reversedStack.pop();
                StackRunner.flats = new Stack<>();
                StackRunner.flats.addAll(reversedStack);
                Flat.count -=1;
                out.writeObject("Последний элемент в коллекции удален");
            }catch (SQLException e){
                out.writeObject("Последний элемент в коллекции не был удален!");
                e.printStackTrace();
            }
    }
}
