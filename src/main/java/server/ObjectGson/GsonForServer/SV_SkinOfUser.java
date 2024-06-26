package server.ObjectGson.GsonForServer;

import javax.persistence.*;

@Entity
@Table(name = "skinofuser")
public class SV_SkinOfUser {
    @Id
    @Column(name = "idUser")
    private int userId;
    @Column(name = "birdskin", nullable = false)
    private String birdSkin;
    @Column(name = "pipeskin", nullable = false)
    private String pipeSkin;

    public SV_SkinOfUser(int userId, String birdSkin, String pipeSkin) {
        this.userId = userId;
        this.birdSkin = birdSkin;
        this.pipeSkin = pipeSkin;
    }

    public SV_SkinOfUser() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBirdSkin() {
        return birdSkin;
    }

    public void setBirdSkin(String birdSkin) {
        this.birdSkin = birdSkin;
    }

    public String getPipeSkin() {
        return pipeSkin;
    }

    public void setPipeSkin(String pipeSkin) {
        this.pipeSkin = pipeSkin;
    }

    @Override
    public String toString() {
        return "SV_SkinOfUser{" +
                "userId=" + userId +
                ", birdSkin='" + birdSkin + '\'' +
                ", pipeSkin='" + pipeSkin + '\'' +
                '}';
    }
}
