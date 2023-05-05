package Client;

import AssemblyMultiMap.MultiMap;
import Launcher.ClientLauncher;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SenderClient {
public static void sender(Socket socket, MultiMap multiMap) throws Exception{
//    try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//         ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
//        System.out.println("Клиент подключен к серверу по порту 8081");
//        System.out.println("Можете начинать работу");
//        out.writeObject(multiMap);
//        String str = (String) inputStream.readObject();
//        System.out.println(str);
//        out.close();
//        inputStream.close();
//        socket.close();
//    } catch (Exception e) {
////                    e.printStackTrace();
//        System.out.println("Невозможно соедениться с сервером, пожалуйста подождите!");
////                System.out.println("Сервер не подключен!");
//    }
        }
}
