package sample.Command.ImplementationCommands;


import sample.Flat.Flat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

import static sample.DesirilizationFromServer.DBConnection.getDBConnection;


public class ImplementationCommandRemoveById {
    private static boolean available;

    public static void RemoveById(Stack<Flat> flats, ArrayList<String> arrayList, ObjectOutputStream out) throws IOException {
        if (flats.size() == 0) {
            out.writeObject("Collection is empty");
            return;
        }
        try {
            for (Flat flat : flats) {
                if (flat.getId() == Integer.parseInt(arrayList.get(0))) {
                    if (flat.getUserName().getNameUser().equals(arrayList.get(1))) {
                        available = true;
                        break;
                    } else {
                        out.writeObject("Вы не являетесь владельцем данного элемента!");
                        return;
                    }
                }
            }
            if (!available) {
                out.writeObject("Такого элемента нет в коллекции!");
            }else{
                flats.removeIf(flat1 -> flat1.getId() == Integer.parseInt(arrayList.get(0)));
                PreparedStatement preparedStatement = getDBConnection().prepareStatement("DELETE FROM flat WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(arrayList.get(0)));
                preparedStatement.executeUpdate();
                PreparedStatement preparedStatement1 = getDBConnection().prepareStatement("UPDATE flat SET id = id - 1 WHERE id > ?;");
                preparedStatement1.setInt(1, Integer.parseInt(arrayList.get(0)));
                preparedStatement1.executeUpdate();
                for(Flat flat1 : flats){
                    if (flat1.getId() > Integer.parseInt(arrayList.get(0))){
                        flat1.setIdWithParametrs(flat1.getId() - 1);
                    }
                }
                out.writeObject("Collection item " + arrayList.get(0) + " has been removed");
            }
        } catch (SQLException e) {
            System.out.println("Не удалось удалить элемент!");
            e.printStackTrace();
        }
//        } else {
//                out.writeObject("The object with id equal " + arrayList.get(0) + " was not found.");
//            }
    }
}
//        else{
//            out.writeObject("Вы не являетесь владельцем этого элемента!");
//            return;
//        }

