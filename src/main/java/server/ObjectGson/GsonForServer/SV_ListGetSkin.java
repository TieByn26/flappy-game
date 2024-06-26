package server.ObjectGson.GsonForServer;

import java.util.ArrayList;

public class SV_ListGetSkin {
    private ArrayList<SV_GetSkin> listGetSkin = new ArrayList<>();

    public SV_ListGetSkin(ArrayList<SV_GetSkin> listGetSkin) {
        this.listGetSkin = listGetSkin;
    }

    public SV_ListGetSkin() {
    }

    public ArrayList<SV_GetSkin> getListGetSkin() {
        return listGetSkin;
    }

    public void setListGetSkin(ArrayList<SV_GetSkin> listGetSkin) {
        this.listGetSkin = listGetSkin;
    }

    @Override
    public String toString() {
        return "SV_ListGetSkin{" +
                "listGetSkin=" + listGetSkin +
                '}';
    }
}
