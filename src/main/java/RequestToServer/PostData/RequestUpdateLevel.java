package RequestToServer.PostData;

import ConnectServer.ConnectServer;
import ObjectGson.GsonForClient.CL_Request;
import ObjectGson.GsonForServer.SV_Level;
import ObjectGson.GsonForServer.SV_Message;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RequestUpdateLevel {
    public static void updateLevel(SV_Level sv_level){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();
        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // gui request den server
            CL_Request request = new CL_Request("/update/level");
            fromClient.write(gson.toJson(request));
            fromClient.newLine();
            fromClient.flush();
            ConnectServer.receiveStatus(socket);

            String jsonRegisterInfo = gson.toJson(sv_level);
            fromClient.write(jsonRegisterInfo);
            fromClient.newLine();
            fromClient.flush();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
