package server.ObjectGson.GsonForServer;

import java.util.ArrayList;

public class SV_ListMessage {
    private ArrayList<SV_Message> listMess = new ArrayList<>();

    public SV_ListMessage(ArrayList<SV_Message> listMess) {
        this.listMess = listMess;
    }

    public SV_ListMessage() {
    }

    public ArrayList<SV_Message> getListMess() {
        return listMess;
    }

    public void setListMess(ArrayList<SV_Message> listMess) {
        this.listMess = listMess;
    }

    @Override
    public String toString() {
        return "SV_ListMessage{" +
                "listMess=" + listMess +
                '}';
    }
}