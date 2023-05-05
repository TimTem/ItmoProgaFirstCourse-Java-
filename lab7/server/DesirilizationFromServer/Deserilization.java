package DesirilizationFromServer;

import Flat.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

import static DesirilizationFromServer.DBConnection.getDBConnection;

public class Deserilization {
    private static ResultSet rs;
    //private static Statement stmt;
    public static void serializationFromServer(Stack<Flat> flats){
    try {
        String sql = "SELECT * FROM flat ORDER BY id;";
        PreparedStatement preparedStatement1 = getDBConnection().prepareStatement(sql);
        rs = preparedStatement1.executeQuery();
        while (rs.next()) {
            // Создание объекта Flat и установка его свойств
            Flat flat = new Flat();
            flat.setId();
            System.out.println(rs.getInt("id"));
            flat.setUser(new User(rs.getString("login")));
            flat.setName(rs.getString("name_flat"));
            flat.setCoordinates(new Coordinates(rs.getInt("x"),rs.getDouble("y") ));
            flat.setCreationDate(rs.getDate("creation_date").toLocalDate());
            flat.setArea(rs.getLong("area"));
            flat.setNumberOfRooms(rs.getLong("num_rooms"));
            flat.setNew(rs.getBoolean("is_new"));
            flat.setFurnish(rs.getString("furnish"));
            flat.setTransport(rs.getString("transport"));
            flat.setHouse(new House(rs.getString("namehouse"), rs.getInt("yearhouse"),rs.getLong("numberofflatsonfloor") ));

            // Добавление объекта Flat в стек
            flats.add(flat);
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
    }
}



