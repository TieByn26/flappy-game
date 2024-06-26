package server.Controller;

import DAO.LoginDAO;
import com.google.gson.Gson;
import server.ObjectGson.GsonForClient.CL_CheckLogin;
import server.ObjectGson.GsonForClient.CL_Login;
import util.StreamSocket;

import java.net.Socket;

public class LoginController {
    public static void checkLogin(Socket socket){
        Gson gson = new Gson();
        //check ket noi
        StreamSocket.checkConnect(socket);
        //doc file du lieu lan 2
        CL_Login cl_login = gson.fromJson(StreamSocket.readGsonFromClient(socket), CL_Login.class);
        try {
            // thuc hien kiem tra
            CL_CheckLogin clCheckLogin = LoginDAO.checkLogin(cl_login);
            //tra du lieu xac nhan ve cho client
            new StreamSocket<CL_CheckLogin>().sendDataToCLient(socket,clCheckLogin);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
