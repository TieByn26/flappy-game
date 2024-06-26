package server.Controller;

import DAO.SettingDAO;
import com.google.gson.Gson;
import server.ObjectGson.GsonForClient.CL_IdUser;
import server.ObjectGson.GsonForServer.SV_Level;
import server.ObjectGson.GsonForServer.SV_Sound;
import util.StreamSocket;

import java.net.Socket;

public class SettingController {
    public static void updateLevel(Socket socket){
        Gson gson = new Gson();
        StreamSocket.checkConnect(socket);
        String fromClient = StreamSocket.readGsonFromClient(socket);
        SV_Level sv_level = gson.fromJson(fromClient,SV_Level.class);
        SettingDAO.updateLevel(sv_level);
    }
    public static void getLevel(Socket socket){
        Gson gson = new Gson();
        StreamSocket.checkConnect(socket);
        String fromClient = StreamSocket.readGsonFromClient(socket);
        CL_IdUser cl_idUser = gson.fromJson(fromClient, CL_IdUser.class);
        SV_Level sv_level = SettingDAO.getLevel(cl_idUser);
        new StreamSocket<SV_Level>().sendDataToCLient(socket,sv_level);
    }
    public static void updateSound(Socket socket){
        Gson gson = new Gson();
        StreamSocket.checkConnect(socket);
        String fromClient = StreamSocket.readGsonFromClient(socket);
        SV_Sound sv_sound = gson.fromJson(fromClient,SV_Sound.class);
        SettingDAO.updateSound(sv_sound);
    }
    public static void getSound(Socket socket){
        Gson gson = new Gson();
        StreamSocket.checkConnect(socket);
        String fromClient = StreamSocket.readGsonFromClient(socket);
        CL_IdUser cl_idUser = gson.fromJson(fromClient, CL_IdUser.class);
        SV_Sound sv_sound = SettingDAO.getSound(cl_idUser);
        new StreamSocket<SV_Sound>().sendDataToCLient(socket,sv_sound);
    }
}