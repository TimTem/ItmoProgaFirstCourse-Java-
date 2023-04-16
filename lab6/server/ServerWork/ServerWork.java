package ServerWork;

import AssemblyMultiMap.MultiMap;
import Commands.Command1;
import Commands.CommandType;
import Json.DesirializeFromJson;
import Launcher.StackRunner;


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
public class ServerWork {

    public void start() throws Exception{
        DesirializeFromJson.fromJson();
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("Сервер запущен на порту 8081");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился к серверу!");
            try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
               while(true){
                   MultiMap multiMap = (MultiMap) inputStream.readObject();
                   StackRunner.runner(multiMap);
                   out.writeObject("Команда была выполнена!");
               }
            }catch (Exception e) {
                System.err.println("Клиент отключился от сервера");
            }
        }
    }
}