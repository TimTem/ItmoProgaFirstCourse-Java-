package Command.ImplementationCommands;
import Flat.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

import static DesirilizationFromServer.DBConnection.getDBConnection;

public class ImplementationCommandAdd{
    private static int resultSet;
    public static synchronized void implementationAdd(Stack<Flat> flats, ArrayList<String> arrayList, ObjectOutputStream out)throws IOException {
        System.out.println("Выполнение команды".toUpperCase());
        try {
            Flat flat = new Flat();
            flat.setId();
            flat.setName(arrayList.get(0));
            flat.setCoordinates(new Coordinates(Double.parseDouble(arrayList.get(1)), Double.parseDouble(arrayList.get(2))));
            flat.setArea(Long.parseLong(arrayList.get(3)));
            flat.setNumberOfRooms(Long.parseLong(arrayList.get(4)));
            flat.setNew(Boolean.parseBoolean(arrayList.get(5)));
            flat.setFurnish(arrayList.get(6));
            flat.setTransport(arrayList.get(7));
            flat.setHouse(new House(arrayList.get(8),Integer.parseInt(arrayList.get(9)),Long.parseLong(arrayList.get(10))));
            flat.setUser(new User(arrayList.get(11)));
            String request = "INSERT INTO flat(id,login,name_flat,x,y,creation_date,area,num_rooms,is_new,furnish,transport,namehouse,yearhouse,numberofflatsonfloor) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = getDBConnection().prepareStatement(request);
            preparedStatement.setInt(1, flat.getId());
            preparedStatement.setString(2, flat.getUser());
            preparedStatement.setString(3,flat.getName());
            preparedStatement.setInt(4, (int) flat.getCoordinates().getX());
            preparedStatement.setDouble(5,flat.getCoordinates().getY());
            preparedStatement.setDate(6, Date.valueOf(flat.getCreationDate()));
            preparedStatement.setInt(7, Math.toIntExact(flat.getArea()));
            preparedStatement.setInt(8, (int) flat.getNumberOfRooms());
            preparedStatement.setBoolean(9,flat.isNew());
            preparedStatement.setString(10,flat.getFurnish().toString());
            preparedStatement.setString(11,flat.getTransport().toString());
            preparedStatement.setString(12,flat.getHouse().getName());
            preparedStatement.setInt(13,flat.getHouse().getYear());
            preparedStatement.setInt(14,(int) flat.getHouse().getNumberOfFlatsOnFloor());
            resultSet = preparedStatement.executeUpdate();
            flats.add(flat);
            out.writeObject("Добавлена новая квартира.");
        }catch (SQLException e){
            out.writeObject("Квартира не добавлена в базу");
        }
//        System.out.println("Добавлена новая квартира.");
    }
}
