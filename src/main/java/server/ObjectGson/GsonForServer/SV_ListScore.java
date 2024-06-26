package server.ObjectGson.GsonForServer;

import java.util.ArrayList;

public class SV_ListScore {
    private ArrayList<SV_Score> listScore = new ArrayList<>();

    public SV_ListScore(ArrayList<SV_Score> listScore) {
        this.listScore = listScore;
    }

    public SV_ListScore() {
    }

    public ArrayList<SV_Score> getListScore() {
        return listScore;
    }

    public void setListScore(ArrayList<SV_Score> listScore) {
        this.listScore = listScore;
    }

    @Override
    public String toString() {
        return "SV_ListScore{" +
                "listScore=" + listScore +
                '}';
    }
}
