package sample.Client;

//import Commands.HelpCommand;


import javafx.scene.control.Alert;
import sample.Flat.Flat;
import sample.Launcher.ClientLauncher;
import sample.Treatment.TreatmentStack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Stack;
//import Launcher.ClientLauncher;

public class ClientWork {
    private static String host = "localhost";
    private static int port = 8081;
    private static Socket socket;

    public static boolean connectToServer() {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
            SendToServer.socket = socket;
            Stack<Flat> stack = (Stack<Flat>) inputStream.readObject();
            TreatmentStack.treatmentStackForClient(stack);
            return true;
//            out.writeObject(ClientLauncher.runner());
//            while (!socket.isOutputShutdown()) {
//                out.writeObject(ClientLauncher.runner());
//                String str = (String) inputStream.readObject();
//                System.out.println(str);
//            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
////                if (receivedObject instanceof String) {
////                    String str = (String) receivedObject;
////                    System.out.println(str);
////                }if (receivedObject instanceof Stack<?>) {
////                    Stack<? extends Flat> genericStack = (Stack<? extends Flat>) receivedObject;
////                    Stack<Flat> typedStack = new Stack<>();
////                    typedStack.addAll(genericStack);
////                    TreatmentStack.treatmentStackForClient(typedStack);
////                }
////                String str = (String) inputStream.readObject();
////                System.out.println(str);
////                Stack<Flat> stack1 = (Stack<Flat>) inputStream.readObject();
////                TreatmentStack.treatmentStackForClient(stack1);
////                ClassForAutentification.autentificationForChekUser();
//
//            }




