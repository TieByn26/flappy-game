package ObjectGson.GsonForServer;

public class SV_Skin {

    private int idskin;
    private String skin;

    public SV_Skin(int idskin, String skin) {
        this.idskin = idskin;
        this.skin = skin;
    }

    public SV_Skin() {
    }

    public int getIdskin() {
        return idskin;
    }

    public void setIdskin(int idskin) {
        this.idskin = idskin;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    @Override
    public String toString() {
        return "SV_Skin{" +
                "idskin=" + idskin +
                ", skin='" + skin + '\'' +
                '}';
    }
}
