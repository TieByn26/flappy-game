package server.GameServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {
    private ServerSocket serverSocket;
    private int port = 5525;
    private ExecutorService executorService;

    public GameServer() throws IOException {
        // Tạo server socket
        serverSocket = new ServerSocket(port);
        System.out.println("Server open port: " + port);

        // Khởi tạo ExecutorService với một thread pool động
        executorService = Executors.newCachedThreadPool();

        // Lặp vô hạn để accept client
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accept connect a Client!");

            // Gửi công việc xử lý request tới ExecutorService
            executorService.execute(() -> ClientHandle.ExecuteClientRequest(socket));
        }
    }

    public static void main(String[] args) throws Exception{
        new GameServer();
    }
}
