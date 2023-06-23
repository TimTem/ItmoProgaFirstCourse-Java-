package sample.ServerWork;

import sample.Command.ImplementationCommands.ImplementationCommandInfo;
import sample.Launcher.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    static ExecutorService executorService = Executors.newCachedThreadPool();
    private static Socket client;
    public static void multiThreadServer(){
        try (ServerSocket serverSocket = new ServerSocket(8081);){
            System.out.println("Сервер запущен на порту 8081");
            // Обработка остальных подключений
            while (!serverSocket.isClosed()) {
                client = serverSocket.accept();
                System.out.println("Клиент подключился!");
                executorService.execute(new ServerWork(client));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
