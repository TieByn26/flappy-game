package ConnectServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectServer {
    private static String ipServer = "";
    private static int port =8080;
    public static Socket getSocket() {
        Socket socket;
        try {
            socket = new Socket(ipServer, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return socket;
    }

    //đọc dữ liệu xác nhận gửi từ server
    public static void receiveStatus(Socket socket){
        BufferedReader fromServer = null;
        try {
            fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            fromServer.readLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}

