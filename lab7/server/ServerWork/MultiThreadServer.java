package ServerWork;

import java.io.IOException;
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
            while (!serverSocket.isClosed()){
                client = serverSocket.accept();
                System.out.println("Клиент подключился!");
                executorService.execute(new ServerWork(client));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
