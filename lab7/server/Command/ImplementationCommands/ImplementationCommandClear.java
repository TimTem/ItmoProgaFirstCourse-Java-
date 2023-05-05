package Command.ImplementationCommands;

import DesirilizationFromServer.Deserilization;
import Flat.Flat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Stack;

import static DesirilizationFromServer.DBConnection.getDBConnection;

public class ImplementationCommandClear {

    public static void implementationClear(Stack<Flat> flats, ObjectOutputStream out) throws IOException {
        if(flats.size() == 0 ){
            out.writeObject("The collection is empty and cannot be cleared");
            return;
        }
            try{
                String str = "DELETE FROM flat";
                PreparedStatement preparedStatement = getDBConnection().prepareStatement(str);
                preparedStatement.executeUpdate();
                Flat.count = 0;
                flats.clear();
            }catch (SQLException e){
                out.writeObject("Не удалось очитить коллекцию!");
                e.printStackTrace();
            }
        out.writeObject("Коллекция была очищена!");
    }
}
