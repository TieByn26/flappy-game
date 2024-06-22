package ObjectGson.GsonForServer;

public class SV_Level {
    private int idUser;
    private int level;
    public SV_Level() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "SV_Level{" +
                "idUser=" + idUser +
                ", level=" + level +
                '}';
    }
}
