package RequestToServer.GetData;

import ConnectServer.ConnectServer;
import ObjectGson.GsonForClient.CL_Request;
import ObjectGson.GsonForServer.SV_ListMessage;
import ObjectGson.GsonForServer.SV_ListUserInfor;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class GetAllUser {
    public static SV_ListUserInfor getAllUser(){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();

        SV_ListUserInfor sv_listUserInfor = null;
        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // gui request den server
            CL_Request request = new CL_Request("/get/all/user");
            String jsonRequest = gson.toJson(request);
            fromClient.write(jsonRequest);
            fromClient.newLine();
            fromClient.flush();
            //lay du lieu
            sv_listUserInfor = gson.fromJson(fromServer.readLine(), SV_ListUserInfor.class);
            System.out.println(sv_listUserInfor);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sv_listUserInfor;
    }
}