package sample.ServerWork;


//import Json.DesirializeFromJson;
import com.sun.tools.javac.Main;
import sample.AssemblyMultiMap.MultiMap;
import sample.Launcher.StackRunner;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Работа сервера, т.е. принимать сериализованные объекты и десириализовывать их.
 */
public class ServerWork implements Runnable {
    //    private static int port = 8081;
//    private static ServerSocket serverSocket;
    private static Socket socket;

    public ServerWork(Socket socket1){
        ServerWork.socket = socket1;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            //Канал записи в сокет
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            //Канал чтения с сокета
            //Пока сокет не закрыт, общаемся с клиентом!
            out.writeObject(StackRunner.flats);
            synchronized (StackRunner.flats){
                while (!socket.isClosed()) {
                    MultiMap multiMap = (MultiMap) inputStream.readObject();
                    StackRunner.runner(multiMap, out);
                }
            }
        } catch (IOException e) {
            System.out.println("Пользователь был отключен!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
