package Client;

//import Commands.HelpCommand;

import Launcher.ClientLauncher;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
//import Launcher.ClientLauncher;

public class ClientWork {
    private static String host = "localhost";
    private static int port = 8081;

    public static void WorkCleint() throws Exception {
        Socket socket = null;
        // создаем сокет для подключения к серверу
            try {
                socket = new Socket(host, port);
                System.out.println("Пожалуйста подождите");
                try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                     ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
                    System.out.println("Клиент подключен к серверу по порту " + port);
                    System.out.println("Можете начинать работу");
                    while (true) {
                        out.writeObject(ClientLauncher.runner());
                        String str = (String) inputStream.readObject();
                        System.out.println(str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
//                    System.out.println("Сервер был отключен!");
//                System.out.println("Сервер не подключен!");
                }
            }catch (Exception e){
                e.printStackTrace();
//                System.err.println("Сервер отключен. Подключение невозможно");
            }
    }
}
// создаем выходной поток и сериализуем объект в него


// закрываем потоки и сокет


//        ClientLauncher.runner();
//        // создаем выходной поток и сериализуем объект Person в него
//        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//        out.writeObject(command1);
//        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
//        String str = (String) inputStream.readObject();
//        System.out.println(str);
//
//        // закрываем потоки и сокет
//        out.close();
//        socket.close();


