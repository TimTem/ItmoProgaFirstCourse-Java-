package sample.ConnectedToServer;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnectedToServer {
    private static String host = "localhost";
    private static int port = 8081;
    private static Socket socket;
    private static Alert alert = new Alert(Alert.AlertType.INFORMATION);



    public static void connectToServer() {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
            System.out.println("пошел на хуй");
//            alert.setTitle("Information");
//            alert.setHeaderText(null);
//            alert.setContentText("Ты подключился к бд!");
//            alert.showAndWait();
//            while(!socket.isOutputShutdown()) {
//                out.writeObject(ClientLauncher.runner());
//                String str = (String) inputStream.readObject();
//                System.out.println(str);
//                ClassForAutentification.autentificationForChekUser();
//            }
        } catch (IOException e) {
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Бд отключена!");
            alert.showAndWait();
        }
    }
}
