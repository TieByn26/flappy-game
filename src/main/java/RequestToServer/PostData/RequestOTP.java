package RequestToServer.PostData;

import ConnectServer.ConnectServer;
import ObjectGson.GsonForClient.*;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RequestOTP {
    public static CL_GetOtp getOtp(CL_CheckOtp cl_checkOtp){
        Gson gson = new Gson();
        CL_GetOtp cl_getOtp = null;
        Socket socket = ConnectServer.getSocket();

        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // Gửi yêu cầu tới server
            CL_Request request = new CL_Request("/get/otp");
            String jsonRequest = gson.toJson(request);
            fromClient.write(jsonRequest);
            fromClient.newLine();
            fromClient.flush();
            ConnectServer.receiveStatus(socket);

            // Gửi dữ liệu đăng ký lên server
            String jsonRegisterInfo = gson.toJson(cl_checkOtp);
            fromClient.write(jsonRegisterInfo);
            fromClient.newLine();
            fromClient.flush();

            // Đọc dữ liệu xác nhận đăng ký từ server
            String read = fromServer.readLine();
            cl_getOtp = gson.fromJson(read, CL_GetOtp.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cl_getOtp;
    }
    public static CL_CheckLogin ForgetPass(CL_ChangePass cl_changePass){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();
        CL_CheckLogin cl_checkLogin = null;
        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // Gửi yêu cầu tới server
            CL_Request request = new CL_Request("/change/password");
            String jsonRequest = gson.toJson(request);
            fromClient.write(jsonRequest);
            fromClient.newLine();
            fromClient.flush();
            ConnectServer.receiveStatus(socket);

            // Gửi dữ liệu đăng ký lên server
            String jsonRegisterInfo = gson.toJson(cl_changePass);
            fromClient.write(jsonRegisterInfo);
            fromClient.newLine();
            fromClient.flush();

            // Đọc dữ liệu xác nhận đăng ký từ server
            String read = fromServer.readLine();
            cl_checkLogin = gson.fromJson(read, CL_CheckLogin.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cl_checkLogin;
    }
}
