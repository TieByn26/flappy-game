package server.ObjectGson.GsonForServer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sound")
public class SV_Sound {
    public SV_Sound(){}
    @Id
    @Column(name = "idUser")
    private int idUser;
    @Column(name = "sound")
    private int sound;

    public SV_Sound(int idUser, int sound) {
        this.idUser = idUser;
        this.sound = sound;
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
