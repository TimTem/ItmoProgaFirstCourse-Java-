import Client.ClientWork;
import Commands.CommandType;
import Launcher.ClientLauncher;
//import Launcher.ClientLauncher;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws Exception{
//        Command1 command1 = new Command1(CommandType.HELP);
//        ClientWork.WorkCleint(command1);
        ClientWork.WorkCleint();
//        ClientLauncher.runner();
    }
}
