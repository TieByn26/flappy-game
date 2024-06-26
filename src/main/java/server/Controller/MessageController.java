package server.Controller;

import DAO.MessageDAO;
import com.google.gson.Gson;
import server.ObjectGson.GsonForServer.SV_ListMessage;
import server.ObjectGson.GsonForServer.SV_Message;
import util.StreamSocket;

import java.net.Socket;
import java.util.stream.Stream;

public class MessageController {
    public MessageController() {
    }

    public static void UpdateMessage(Socket socket) {
        Gson gson = new Gson();
        // Check ket noi
        StreamSocket.checkConnect(socket);
        // doc du lieu de update
        SV_Message svMessage = gson.fromJson(StreamSocket.readGsonFromClient(socket), SV_Message.class);
        MessageDAO.updateMess(svMessage);
    }
    public static void GetAllMessage(Socket socket){
        // gui du lieu ve client
        new StreamSocket<SV_ListMessage>().sendDataToCLient(socket, MessageDAO.getAllMessage());
    }
}
