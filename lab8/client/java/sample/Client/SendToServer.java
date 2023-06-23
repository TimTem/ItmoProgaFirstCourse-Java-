package sample.Client;

import sample.AssemblyMultiMap.MultiMap;
import sample.Flat.Flat;
import sample.Launcher.ClientLauncher;
import sample.Treatment.TreatmentStack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Stack;

public class SendToServer {
    private static String host = "localhost";
    private static int port = 8081;
    public static Socket socket;
    public static void sendMultiMap(MultiMap multiMap){
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
            Stack<Flat> stack = (Stack<Flat>) inputStream.readObject();
            TreatmentStack.treatmentStackForClient(stack);
             if(multiMap == null){
                 return;
             }else{
                 out.writeObject(multiMap);
             }
             if(inputStream.available() > 0){
                 Object object = (Object) inputStream.readObject();
                 if(object instanceof String){
                     String string = (String) object;
                     ClientLauncher.infoFlat = string;
                     return;
                 }
                 if(object instanceof Float){
                     Float float1 = (Float) object;
                     ClientLauncher.average = float1;
                     return;
                 }
             }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
