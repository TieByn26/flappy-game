package server.Controller;

import DAO.UserDAO;
import com.google.gson.Gson;
import server.ObjectGson.GsonForClient.CL_ChangePass;
import server.ObjectGson.GsonForClient.CL_CheckLogin;
import server.ObjectGson.GsonForClient.CL_CheckOtp;
import server.ObjectGson.GsonForClient.CL_GetOtp;
import util.EmailService;
import util.StreamSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ForgetController {
    public static void sendOtp(Socket socket) throws IOException {
        Gson gson = new Gson();
        //check status
        StreamSocket.checkConnect(socket);
        //doc file du lieu lan 2
        CL_CheckOtp cl_checkOtp = gson.fromJson(StreamSocket.readGsonFromClient(socket), CL_CheckOtp.class);
        //gui opt den mail nguoi dung
        int OTP  = (int)((Math.random()+1)*1000);
        String subject = "MÃ KHÔI PHỤC MẬT KHẨU";
        String content = "Đây là mã khôi phục mật khẩu: "+ OTP +"\n"+
                "Vui lòng không chia sẻ mã này dưới bất kỳ hình thức nào \n" +
                "Nếu gặp trở ngại, hãy liên hệ 123456789 để được hỗ trợ \n" +
                "Thân ái! \n " +
                "Admin.";
        String email = UserDAO.getMailByUsername(cl_checkOtp.getUsername());
        CL_GetOtp cl_getOtp = new CL_GetOtp(OTP);
        //gui du lieu ve client
        if (EmailService.sendMail(email,subject,content)){
            new StreamSocket<CL_GetOtp>().sendDataToCLient(socket, cl_getOtp);
        }else {
            DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
            toClient.writeBytes("false");
            toClient.flush();
        }
    }
    public static void changePassword(Socket socket){
        Gson gson = new Gson();
        //check ket noi
        StreamSocket.checkConnect(socket);
        //doc file du lieu lan 2
        String fromClient = StreamSocket.readGsonFromClient(socket);
        CL_ChangePass cl_changePass = gson.fromJson(fromClient, CL_ChangePass.class);
        try {
            UserDAO.changePassword(cl_changePass);
            CL_CheckLogin cl_checkLogin = new CL_CheckLogin();
            cl_checkLogin.setCheck(true);
            new StreamSocket<CL_CheckLogin>().sendDataToCLient(socket, cl_checkLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
