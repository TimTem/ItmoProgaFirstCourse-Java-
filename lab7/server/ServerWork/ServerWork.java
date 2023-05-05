package ServerWork;

import AssemblyMultiMap.MultiMap;
import Commands.Command1;
import Commands.CommandType;
//import Json.DesirializeFromJson;
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
            while (!socket.isClosed()) {
                MultiMap multiMap = (MultiMap) inputStream.readObject();
                StackRunner.runner(multiMap, out);
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

//    public static void start() throws IOException{
//        serverSocket = new ServerSocket(port);
//        while (true){
//            System.out.println("Сервер запущен на порту 8081");
//            try {
//                Socket socket = serverSocket.accept();
//                System.out.println("Клиент подключен!");
//                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//                //Канал записи в сокет
//                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
//                //Канал чтения с сокета
//                //Пока сокет не закрыт, общаемся с клиентом!
//                while (!socket.isClosed()){
//                    MultiMap multiMap = (MultiMap) inputStream.readObject();
//                    StackRunner.runner(multiMap, out);
//                }
//            }catch (IOException e){
//                System.out.println("Пользователь был отключен!");
//            }catch (ClassNotFoundException e){
//                e.printStackTrace();
//            }
//        }
//        catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//            ClientHandler clientHandler = new ClientHandler(socket);
//            new Thread(clientHandler).start();


//    }
//    public void exitCheck(ObjectOutputStream out, ObjectInputStream inputStream, MultiMap multiMap){
//
//    }
//    public static void stop() throws IOException {
//        serverSocket.close();
//    }

//    private static class ClientHandler implements Runnable {
//        private Socket clientSocket;
//
//        public ClientHandler(Socket clientSocket) {
//            this.clientSocket = clientSocket;
//        }
//        @Override
//        public void run(){
//            try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
//                 ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());) {
//                      MultiMap multiMap = (MultiMap) inputStream.readObject();
//                      StackRunner.runner(multiMap, out);
//            }catch (Exception e) {
//                e.printStackTrace();
////                System.err.println("Клиент отключился от сервера");
//            }
//        }
//    }
//    public void start() throws Exception{
//        ServerSocket serverSocket = new ServerSocket(8081);
//        System.out.println("Сервер запущен на порту 8081");
//        while (true) {
//            Socket socket = serverSocket.accept();
//            try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//                 ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
////               while(true){
//                   MultiMap multiMap = (MultiMap) inputStream.readObject();
//                   StackRunner.runner(multiMap, out);
////               }
//            }catch (EOFException e) {
//                e.printStackTrace();
////                System.err.println("Клиент отключился от сервера");
//            }
//        }
//    }
//}
