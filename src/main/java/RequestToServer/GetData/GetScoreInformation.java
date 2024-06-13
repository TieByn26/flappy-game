package RequestToServer.GetData;

import ConnectServer.ConnectServer;
import ObjectGson.GsonForClient.CL_Request;
import ObjectGson.GsonForServer.SV_ListGetSkin;
import ObjectGson.GsonForServer.SV_ListScore;
import ObjectGson.GsonForServer.SV_ListUserInfor;
import ObjectGson.GsonForServer.SV_Score;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class GetScoreInformation {
    public static SV_ListScore getScoreRank(){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();
        SV_ListScore sv_listScore = null;

        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // gui request den server
            CL_Request request = new CL_Request("/get/rank/score");
            String jsonRequest = gson.toJson(request);
            fromClient.write(jsonRequest);
            fromClient.newLine();
            fromClient.flush();

            //doc du lieu tu server
            sv_listScore = gson.fromJson(fromServer.readLine(),SV_ListScore.class);
            System.out.println(sv_listScore);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sv_listScore;
    }
    public static SV_ListUserInfor getScoreOfUser(){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();
        SV_ListUserInfor sv_listUserInfor = null;

        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // gui request den server
            CL_Request request = new CL_Request("/get/rank/username");
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
    public static SV_ListGetSkin getSkinForRank(){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();
        SV_ListGetSkin sv_listGetSkin = null;

        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // gui request den server
            CL_Request request = new CL_Request("/get/rank/skin");
            String jsonRequest = gson.toJson(request);
            fromClient.write(jsonRequest);
            fromClient.newLine();
            fromClient.flush();
            //lay du lieu
            sv_listGetSkin = gson.fromJson(fromServer.readLine(), SV_ListGetSkin.class);
            System.out.println(sv_listGetSkin);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sv_listGetSkin;
    }
}
