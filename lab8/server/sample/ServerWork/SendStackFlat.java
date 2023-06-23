package sample.ServerWork;

import sample.Command.ImplementationCommands.ImplementationCommandInfo;
import sample.Commands.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import sample.Launcher.*;

public class SendStackFlat {
    public static void sendToClient(Socket clientSocket){
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(StackRunner.flats);
            ImplementationCommandInfo.implementationInfo(StackRunner.flats, out);
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
