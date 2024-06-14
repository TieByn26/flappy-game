package RequestToServer.GetData;

import ConnectServer.ConnectServer;
import ObjectGson.GsonForClient.CL_Request;
import ObjectGson.GsonForServer.SV_ListGetSkin;
import ObjectGson.GsonForServer.SV_ListMessage;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class GetAllMess {
    public static SV_ListMessage getAllMessage(){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();

        SV_ListMessage svListMessage = null;
        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // gui request den server
            CL_Request request = new CL_Request("/get/all/message");
            String jsonRequest = gson.toJson(request);
            fromClient.write(jsonRequest);
            fromClient.newLine();
            fromClient.flush();
            //lay du lieu
            svListMessage = gson.fromJson(fromServer.readLine(), SV_ListMessage.class);
            System.out.println(svListMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return svListMessage;
    }
}