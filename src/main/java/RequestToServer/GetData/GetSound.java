package RequestToServer.GetData;

import ConnectServer.ConnectServer;
import ObjectGson.GsonForClient.CL_IdUser;
import ObjectGson.GsonForClient.CL_Request;
import ObjectGson.GsonForServer.SV_Level;
import ObjectGson.GsonForServer.SV_Sound;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class GetSound {
    public static SV_Sound getSound(CL_IdUser cl_idUser){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();

        SV_Sound sv_sound = null;
        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // gui request den server
            CL_Request request = new CL_Request("/get/sound");
            String jsonRequest = gson.toJson(request);
            fromClient.write(jsonRequest);
            fromClient.newLine();
            fromClient.flush();
            ConnectServer.receiveStatus(socket);

            //gui id user len
            String jsonId = gson.toJson(cl_idUser);
            fromClient.write(jsonId);
            fromClient.newLine();
            fromClient.flush();

            //lay du lieu
            sv_sound = gson.fromJson(fromServer.readLine(), SV_Sound.class);
            System.out.println(sv_sound);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sv_sound;
    }
}