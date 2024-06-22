package ObjectGson.GsonForServer;

public class SV_Sound {
    private int idUser;
    private int sound;

    public SV_Sound() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "SV_Sound{" +
                "idUser=" + idUser +
                ", sound=" + sound +
                '}';
    }
}
