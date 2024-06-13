package RequestToServer.PostData;

import ConnectServer.ConnectServer;
import ObjectGson.GsonForClient.CL_Request;
import ObjectGson.GsonForServer.SV_Score;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RequestUpdateScore {
    public static void updateScore(SV_Score sv_score){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();

        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // gui request den server
            CL_Request request = new CL_Request("/update/score");
            String jsonRequest = gson.toJson(request);
            fromClient.write(jsonRequest);
            fromClient.newLine();
            fromClient.flush();
            ConnectServer.receiveStatus(socket);
            // gui du lieu len de update

            String jsonUpdateScore = gson.toJson(sv_score);
            fromClient.write(jsonUpdateScore);
            fromClient.newLine();
            fromClient.flush();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
