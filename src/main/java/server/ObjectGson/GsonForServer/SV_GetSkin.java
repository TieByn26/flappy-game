package server.ObjectGson.GsonForServer;

public class SV_GetSkin {
    private String skinBird;
    private String skinPipe;

    public SV_GetSkin(String skinBird, String skinPipe) {
        this.skinBird = skinBird;
        this.skinPipe = skinPipe;
    }

    public SV_GetSkin() {
    }

    public String getSkinBird() {
        return skinBird;
    }

    public void setSkinBird(String skinBird) {
        this.skinBird = skinBird;
    }

    public String getSkinPipe() {
        return skinPipe;
    }

    public void setSkinPipe(String skinPipe) {
        this.skinPipe = skinPipe;
    }

    @Override
    public String toString() {
        return "SV_GetSkin{" +
                "skinBird='" + skinBird + '\'' +
                ", skinPipe='" + skinPipe + '\'' +
                '}';
    }
}
