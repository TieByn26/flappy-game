package server.ObjectGson.GsonForServer;

import java.util.ArrayList;

public class SV_ListUserInfor {
    private ArrayList<SV_UserInfor> listUserInfor = new ArrayList<>();

    public SV_ListUserInfor(ArrayList<SV_UserInfor> listUserInfor) {
        this.listUserInfor = listUserInfor;
    }

    public SV_ListUserInfor() {
    }

    public ArrayList<SV_UserInfor> getListUserInfor() {
        return listUserInfor;
    }

    public void setListUserInfor(ArrayList<SV_UserInfor> listUserInfor) {
        this.listUserInfor = listUserInfor;
    }

    @Override
    public String toString() {
        return "SV_ListUserInfor{" +
                "listUserInfor=" + listUserInfor +
                '}';
    }
}
