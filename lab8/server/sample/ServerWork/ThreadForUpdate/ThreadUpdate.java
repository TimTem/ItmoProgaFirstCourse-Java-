package sample.ServerWork.ThreadForUpdate;

import sample.Flat.Flat;
import sample.Flat.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Stack;

public class ThreadUpdate implements Runnable{
    private static Socket socket;
    private static int collectionItemNumber;
    private static User user;
    private static Stack<Flat> flats;

    public static void setFlats(Stack<Flat> flats) {
        ThreadUpdate.flats = flats;
    }

    public static void setSocket(Socket socket) {
        ThreadUpdate.socket = socket;
    }

    @Override
    public void run(){
        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             //Канал записи в сокет
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());){
            while (!socket.isClosed()) {
                ArrayList<String> multiMap = (ArrayList<String>) inputStream.readObject();

            }
        }catch (Exception e){
        e.printStackTrace();
        }
    }
}
