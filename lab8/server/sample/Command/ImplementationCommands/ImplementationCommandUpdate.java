package sample.Command.ImplementationCommands;

import sample.Flat.*;
import sample.Flat.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.*;
import static sample.DesirilizationFromServer.DBConnection.getDBConnection;

public class ImplementationCommandUpdate {
    public static int id;
    private static User user;
    private static int collectionId;
    private static ResultSet resultSet;
    private static int resultSet1;

    //    public void update(ArrayList<String> arrayList, ObjectOutputStream out) {
//        try {
//            for (Flat flat : StackRunner.flats) {
//                if (flat.getId() == Integer.parseInt(arrayList.get(0))) {
//                    if (flat.getUserName().getNameUser().equals(arrayList.get(1))) {
//                        out.writeObject("Введите данные, которые хотите изменить!");
//                    } else {
//                        out.writeObject("Этот элемент принадлежит не вам!");
//                        return;
//                    }
//                } else {
//                    out.writeObject("Такого элемента в коллекции нет!");
//                    return;
//                }
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
    public static void updateElementCollection
    (Stack<Flat> flats, ArrayList<String> arrayList, ObjectOutputStream out) {
        try {
            Pattern pattern = Pattern.compile("[1-9]*");
            Matcher mt = pattern.matcher(arrayList.get(0));
            if (mt.matches()) {
                PreparedStatement preparedStatement = getDBConnection().prepareStatement("SELECT id FROM flat WHERE id = ?");
                preparedStatement.setInt(1, parseInt(arrayList.get(0)));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    System.out.println(id);
                    PreparedStatement preparedStatement1 = getDBConnection().prepareStatement("SELECT login FROM flat WHERE id = ?");
                    preparedStatement1.setInt(1, id);
                    resultSet = preparedStatement1.executeQuery();
                    if (resultSet.next()) {
                        if (resultSet.getString("login").equals(arrayList.get(12))) {
                            PreparedStatement preparedStatement2 = getDBConnection().prepareStatement("UPDATE flat SET name_flat = ?, x = ?, y = ?, area = ?, num_rooms = ?, is_new = ?, furnish = ?, transport = ?, namehouse = ?, yearhouse = ?, numberofflatsonfloor = ? WHERE id = ?;");
                            preparedStatement2.setString(1, arrayList.get(1));
                            preparedStatement2.setInt(2, (int) Double.parseDouble(arrayList.get(2)));
                            preparedStatement2.setDouble(3, Double.parseDouble(arrayList.get(3)));
                            preparedStatement2.setInt(4, Integer.parseInt(arrayList.get(4)));
                            preparedStatement2.setInt(5, Integer.parseInt(arrayList.get(5)));
                            preparedStatement2.setBoolean(6, Boolean.parseBoolean(arrayList.get(6)));
                            preparedStatement2.setString(7, arrayList.get(7));
                            preparedStatement2.setString(8, arrayList.get(8));
                            preparedStatement2.setString(9, arrayList.get(9));
                            preparedStatement2.setInt(10, Integer.parseInt(arrayList.get(10)));
                            preparedStatement2.setInt(11, Integer.parseInt(arrayList.get(11)));
                            preparedStatement2.setInt(12, id);
                            resultSet1 = preparedStatement2.executeUpdate();

                            Iterator<Flat> iterator = flats.iterator();
                            while (iterator.hasNext()) {
                                Flat flat = iterator.next();
                                if (Integer.parseInt(arrayList.get(0)) == flat.getId()) {
                                    if (flat.getUserName().getNameUser().equals(arrayList.get(12))) {
                                        try {
//                        //Допиши запрос на обновление
                                            flat.setName(arrayList.get(1));
                                            flat.setCoordinates(new Coordinates(Double.parseDouble(arrayList.get(2)), Double.parseDouble(arrayList.get(3))));
                                            flat.setArea(Long.parseLong(arrayList.get(4)));
                                            flat.setNumberOfRooms(Long.parseLong(arrayList.get(5)));
                                            flat.setNew(Boolean.parseBoolean(arrayList.get(6)));
                                            flat.setFurnish(arrayList.get(7));
                                            flat.setTransport(arrayList.get(8));
                                            flat.setHouse(new House(arrayList.get(9), Integer.parseInt(arrayList.get(10)), Long.parseLong(arrayList.get(11))));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }

                            //out.writeObject("Изменена квартира № " + arrayList.get(0) + ".");
                            System.out.println("Изменена квартира № " + arrayList.get(0) + ".");
                            return;
                        } else {
                            //out.writeObject("Вы не можете изменить квартиру, потому что вы не владелец квартиры!");
                            return;
                        }
                    }
                } else {
                    //out.writeObject("Такого элемента нет в коллекции");
                    return;
                }
            } else {
                //out.writeObject("Неизвестный синтаксис!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


//        Iterator<Flat> iterator = flats.iterator();
//        while(iterator.hasNext()){
//            Flat flat = iterator.next();
//            if(Integer.parseInt(arrayList.get(0)) == flat.getId()){
//                if (flat.getUserName().getNameUser().equals(arrayList.get(12))){
//                    try {
////                        //Допиши запрос на обновление
////                        flat.setName(arrayList.get(1));
////                        flat.setCoordinates(new Coordinates(Double.parseDouble(arrayList.get(2)), Double.parseDouble(arrayList.get(3))));
////                        flat.setArea(Long.parseLong(arrayList.get(4)));
////                        flat.setNumberOfRooms(Long.parseLong(arrayList.get(5)));
////                        flat.setNew(Boolean.parseBoolean(arrayList.get(6)));
////                        flat.setFurnish(arrayList.get(7));
////                        flat.setTransport(arrayList.get(8));
////                        flat.setHouse(new House(arrayList.get(9), Integer.parseInt(arrayList.get(10)), Long.parseLong(arrayList.get(11))));
//                        String request = "UPDATE flat SET name_flat = ?, x = ?, y = ?, area = ?, num_rooms = ?, is_new = ?, furnish = ?, transport = ?, namehouse = ?, yearhouse = ?, numberofflatsonfloor = ? WHERE id = ?;";
//                        PreparedStatement preparedStatement = getDBConnection().prepareStatement(request);
//                        preparedStatement.setInt(12, flat.getId());
//                        preparedStatement.setString(1, flat.getName());
//                        preparedStatement.setInt(2, (int) flat.getCoordinates().getX());
//                        preparedStatement.setDouble(3, flat.getCoordinates().getY());
//                        preparedStatement.setInt(4, Math.toIntExact(flat.getArea()));
//                        preparedStatement.setInt(5, Math.toIntExact(flat.getNumberOfRooms()));
//                        preparedStatement.setBoolean(6, flat.isNew());
//                        preparedStatement.setString(7, flat.getFurnish().toString());
//                        preparedStatement.setString(8, flat.getTransport().toString());
//                        preparedStatement.setString(9, flat.getHouse().getName());
//                        preparedStatement.setInt(10, flat.getHouse().getYear());
//                        preparedStatement.setInt(11, Math.toIntExact(flat.getHouse().getNumberOfFlatsOnFloor()));
//                        resultSet = preparedStatement.executeUpdate();
//                        out.writeObject("Изменена квартира № " + arrayList.get(0) + ".");
//                        return;
//                        } catch (Exception e) {
//                            System.out.println("ПОШЕЛ НАХУЙ!");
//                            e.printStackTrace();
//                        }
//                }else {
//                        out.writeObject("Вы не можете изменить эту квартиру! Потому что вы не владелец данного элемента!");
//                        return;
//                    }
//            }else{
//                out.writeObject("Такого элемента нет в коллекции!");
//                    return;
//            }
//        }

////            id = Integer.parseInt(arrayList.get(0));
//            System.out.println("Выполнение команды".toUpperCase());
//            for (Flat flat : StackRunner.flats) {
//                if (flat.getId() == Integer.parseInt(arrayList.get(0))) {
//                    if (flat.getUserName().getNameUser().equals(arrayList.get(12))) {
//                        try {
//                        //Допиши запрос на обновление
//                        flat.setName(arrayList.get(1));
//                        flat.setCoordinates(new Coordinates(Double.parseDouble(arrayList.get(2)), Double.parseDouble(arrayList.get(3))));
//                        flat.setArea(Long.parseLong(arrayList.get(4)));
//                        flat.setNumberOfRooms(Long.parseLong(arrayList.get(5)));
//                        flat.setNew(Boolean.parseBoolean(arrayList.get(6)));
//                        flat.setFurnish(arrayList.get(7));
//                        flat.setTransport(arrayList.get(8));
//                        flat.setHouse(new House(arrayList.get(9), Integer.parseInt(arrayList.get(10)), Long.parseLong(arrayList.get(11))));
//                        String request = "UPDATE flat SET name_flat = ?, x = ?, y = ?, area = ?, num_rooms = ?, is_new = ?, furnish = ?, transport = ?, namehouse = ?, yearhouse = ?, numberofflatsonfloor = ? WHERE id = ?;";
//                        PreparedStatement preparedStatement = getDBConnection().prepareStatement(request);
//                        preparedStatement.setInt(12, flat.getId());
//                        preparedStatement.setString(1, flat.getName());
//                        preparedStatement.setInt(2, (int) flat.getCoordinates().getX());
//                        preparedStatement.setDouble(3, flat.getCoordinates().getY());
//                        preparedStatement.setInt(4, Math.toIntExact(flat.getArea()));
//                        preparedStatement.setInt(5, Math.toIntExact(flat.getNumberOfRooms()));
//                        preparedStatement.setBoolean(6, flat.isNew());
//                        preparedStatement.setString(7, flat.getFurnish().toString());
//                        preparedStatement.setString(8, flat.getTransport().toString());
//                        preparedStatement.setString(9, flat.getHouse().getName());
//                        preparedStatement.setInt(10, flat.getHouse().getYear());
//                        preparedStatement.setInt(11, Math.toIntExact(flat.getHouse().getNumberOfFlatsOnFloor()));
//                        resultSet = preparedStatement.executeUpdate();
//                        out.writeObject("Изменена квартира № " + arrayList.get(0) + ".");
//                        return;
//                        } catch (Exception e) {
//                            System.out.println("ПОШЕЛ НАХУЙ!");
//                            e.printStackTrace();
//                        }
//                    } else {
//                        out.writeObject("Вы не можете изменить эту квартиру! Потому что вы не владелец данного элемента!");
//                        return;
//                    }
//                } else {
//                    out.writeObject("Такого элемента нет в коллекции!");
//                    return;
//                }
//            }
//    }

