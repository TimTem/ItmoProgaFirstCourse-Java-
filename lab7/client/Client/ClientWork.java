package Client;

//import Commands.HelpCommand;

import AssemblyMultiMap.MultiMap;
import AuthorizationClient.Config;
import Commands.CommandType;
import Launcher.ClientLauncher;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
//import Launcher.ClientLauncher;

public class ClientWork {
    private static String host = "localhost";
    private static int port = 8081;
    private static Socket socket;
//    private static Socket socket;
//    private static ObjectOutputStream out;
//    private static ObjectInputStream inputStream;


    public static void connectToServer() {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
            while(!socket.isOutputShutdown()) {
                out.writeObject(ClientLauncher.runner());
                String str = (String) inputStream.readObject();
                System.out.println(str);
            }
        } catch (IOException e) {
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public static void sendToServer(ObjectOutputStream out, MultiMap multiMap, ObjectInputStream inputStream) {
//       try {
//           out.writeObject(multiMap);
//           String str = (String) inputStream.readObject();
//           System.out.println(str);
//       }catch (IOException e){
//           e.printStackTrace();
//       }catch (ClassNotFoundException e){
//           e.printStackTrace();
//       }
    }

//    public static void connectToServer() {
//        try {
//            socket = new Socket(host, port);
//            ClientLauncher.runner();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void closeSocket() throws Exception {
//        socket.close();
//    }
//
//    public static void sendToServer(MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap) {
////            try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
////                 ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
//        try(ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
//            out.writeObject(multiMap);
//            String str = (String) inputStream.readObject();
//            System.out.println(str);
//        }
//            catch(IOException e){
//            System.out.println("Отправка команды невозможна!");
//        }catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }
//    }


//    public static void WorkCleint( MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap) throws Exception {
//        Socket socket = null;
//        // создаем сокет для подключения к серверу
//            try {
//                socket = new Socket(host, port);
//                try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//                     ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
//                        out.writeObject(multiMap);
//                        String str = (String) inputStream.readObject();
//                        System.out.println(str);
//                        out.close();
//                        inputStream.close();
//                        socket.close();
//                } catch (EOFException e) {
////                    e.printStackTrace();
////                    System.out.println("Невозможно соедениться с сервером, пожалуйста подождите!");
////                System.out.println("Сервер не подключен!");
//                }
//            }catch (Exception e){
////                e.printStackTrace();
////                System.err.println("Сервер отключен. Подключение невозможно");
//                System.out.println("Отправка команды невозможна. Сервер отключен. Подключение невозможно");
//            }
//    }




