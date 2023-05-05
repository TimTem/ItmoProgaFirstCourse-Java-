package Command.ImplementationCommands;

import Flat.Flat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

import static DesirilizationFromServer.DBConnection.getDBConnection;

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
                float counter = resultSet.getFloat("avg_flats_per_floor");
                out.writeObject("The average value of the numberOfRooms field for all elements of the collection: " + counter);
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
