package sample.Command.ImplementationCommands;



import sample.Flat.Flat;
import sample.Flat.Flat.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


import static sample.DesirilizationFromServer.DBConnection.getDBConnection;

public class ImplementationCommandClear {

    public static void implementationClear(Stack<Flat> flats, ArrayList<String> stringArrayList, ObjectOutputStream out) throws IOException {
        if(flats.size() == 0 ){
            System.out.println(stringArrayList.get(0));
            out.writeObject("The collection is empty and cannot be cleared");
            out.writeObject(flats);
            return;
        }
            try{
                String str = "DELETE FROM flat WHERE login = ?";
                PreparedStatement preparedStatement = getDBConnection().prepareStatement(str);
                preparedStatement.setString(1, stringArrayList.get(0));
                preparedStatement.executeUpdate();
                Flat.count = 0;
                Iterator<Flat> iterator = flats.iterator();
                while(iterator.hasNext()){
                    Flat flat = iterator.next();
                    if(flat.getUserName().getNameUser().equals(stringArrayList.get(0))){
                        iterator.remove();
                    }
                    out.writeObject("Коллекция была очищена!");
                }
            }catch (SQLException e){
                out.writeObject("Не удалось очитить коллекцию!");
                e.printStackTrace();
            }
    }
}
