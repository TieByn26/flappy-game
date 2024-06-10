package RequestToServer.PostData;
import ConnectServer.ConnectServer;
import ObjectGson.GsonForClient.CL_CheckLogin;
import ObjectGson.GsonForClient.CL_Login;
import ObjectGson.GsonForClient.CL_Request;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RequestLoginn {
    public static CL_CheckLogin requestLogin(CL_Login cl_login){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();
        CL_CheckLogin clCheckLogin = null;
        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // gui request den server
            CL_Request request = new CL_Request("/check/login");
            String jsonRequest = gson.toJson(request);
            fromClient.write(jsonRequest);
            fromClient.newLine();
            fromClient.flush();
            ConnectServer.receiveStatus(socket);

            // gui thong tin dang ky tai khoan den server
            String jsonRegisterInfo = gson.toJson(cl_login);
            fromClient.write(jsonRegisterInfo);
            fromClient.newLine();
            fromClient.flush();

            // doc xac nhan tu server
            String confirmation = fromServer.readLine();
            clCheckLogin = gson.fromJson(confirmation, CL_CheckLogin.class);
            System.out.println("Server response: " +clCheckLogin);

        } catch (Exception e){
            e.printStackTrace();
        }
        return clCheckLogin;
    }
}
