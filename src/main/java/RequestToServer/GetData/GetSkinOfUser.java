package RequestToServer.GetData;

import ConnectServer.ConnectServer;
import ObjectGson.GsonForClient.CL_CheckLogin;
import ObjectGson.GsonForClient.CL_Request;
import ObjectGson.GsonForServer.SV_GetSkin;
import ObjectGson.GsonForServer.SV_SkinOfUser;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class GetSkinOfUser {
    public static SV_GetSkin getSKinOfUser(CL_CheckLogin cl_checkLogin){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();
        SV_GetSkin sv_getSkin = null;
        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // gui request den server
            CL_Request request = new CL_Request("/get/skin/of/user");
            String jsonRequest = gson.toJson(request);
            fromClient.write(jsonRequest);
            fromClient.newLine();
            fromClient.flush();
            ConnectServer.receiveStatus(socket);

            //gui id user len
            String jsonId = gson.toJson(cl_checkLogin);
            fromClient.write(jsonId);
            fromClient.newLine();
            fromClient.flush();

            //doc du lieu gui ve
            String confirmation = fromServer.readLine();
            sv_getSkin = gson.fromJson(confirmation, SV_GetSkin.class);
            System.out.println("Server response: " +sv_getSkin);


        }catch (Exception e){
            e.printStackTrace();
        }
        return sv_getSkin;
    }
}
