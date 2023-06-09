package sample.Command.ImplementationCommands;


import sample.Flat.Flat;
import sample.Flat.Flat.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

import static sample.DesirilizationFromServer.DBConnection.getDBConnection;


public class ImplementationCommandAverageOfNumberOfRooms {
    private static ResultSet resultSet;
    public static void averageOfNumberOfRooms(Stack<Flat> flats, ObjectOutputStream out)throws IOException {
        try {
            if (flats.size() == 0) {
                out.writeObject("Collection empty");
                return;
            }
            PreparedStatement preparedStatement = getDBConnection().prepareStatement("SELECT SUM(numberofflatsonfloor)::float / (SELECT COUNT(*) FROM flat) AS avg_flats_per_floor FROM flat;");
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Float counter = resultSet.getFloat("avg_flats_per_floor");
                out.writeObject(counter);
            }
//        long counter = 0;
//        for (Flat flat : flats) {
//            counter += flat.getNumberOfRooms();
//        }
//        Math.round(counter /= flats.size());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
