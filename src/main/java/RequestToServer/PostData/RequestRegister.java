package RequestToServer.PostData;

import ConnectServer.ConnectServer;
import ObjectGson.GsonForClient.CL_RegisterInformation;
import ObjectGson.GsonForClient.CL_Request;
import ObjectGson.GsonForServer.SV_Check;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RequestRegister {
    public static SV_Check requestRegister(CL_RegisterInformation cl_registerInformation){
        Gson gson = new Gson();
        Socket socket = ConnectServer.getSocket();
        SV_Check sv_check = null;
        try (BufferedWriter fromClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // gui request den server
            CL_Request request = new CL_Request("/register/account");
            System.out.println(request);
            fromClient.write(gson.toJson(request));
            fromClient.newLine();
            fromClient.flush();
            ConnectServer.receiveStatus(socket);

            // gui thong tin dang ky tai khoan den server
            String jsonRegisterInfo = gson.toJson(cl_registerInformation);
            fromClient.write(jsonRegisterInfo);
            fromClient.newLine();
            fromClient.flush();

            // doc xac nhan tu server
            String confirmation = fromServer.readLine();
            sv_check = gson.fromJson(confirmation, SV_Check.class);
            System.out.println("Server response: " +sv_check);

        } catch (Exception e){
            e.printStackTrace();
        }
        return sv_check;
    }
}
