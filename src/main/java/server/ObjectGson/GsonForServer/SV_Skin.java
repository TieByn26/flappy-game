package server.ObjectGson.GsonForServer;

import javax.persistence.*;

@Entity
@Table (name = "skin")
public class SV_Skin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSkin")
    private int idskin;
    @Column(name = "skin")
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
