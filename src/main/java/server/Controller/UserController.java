package server.Controller;

import DAO.ScoreDAO;
import DAO.UserDAO;
import server.ObjectGson.GsonForServer.SV_ListScore;
import server.ObjectGson.GsonForServer.SV_ListUserInfor;
import util.StreamSocket;

import java.net.Socket;

public class UserController {
    public static void getTop3User(Socket socket){
        //gui du lieu cho client
        SV_ListScore sv_listScore = ScoreDAO.getTop3Scores();
        SV_ListUserInfor sv_listUserInfor = UserDAO.getTop3UserInfor(sv_listScore);
        new StreamSocket<SV_ListUserInfor>().sendDataToCLient(socket,sv_listUserInfor);
    }
    public static void getAllUser(Socket socket){
        new StreamSocket<SV_ListUserInfor>().sendDataToCLient(socket, UserDAO.getAllUser());
    }
}