package server.ObjectGson.GsonForServer;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "userinformation")
public class SV_UserInfor {
    @Id
    @Column(name = "userId")
    private int userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "idSkin", nullable = false)
    private int idSkin;

    public SV_UserInfor(int userId, String username, int idSkin) {
        this.userId = userId;
        this.username = username;
        this.idSkin = idSkin;
    }

    public SV_UserInfor() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdSkin() {
        return idSkin;
    }

    public void setIdSkin(int idSkin) {
        this.idSkin = idSkin;
    }


    @Override
    public String toString() {
        return "SV_UserInfor{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", idSkin=" + idSkin +
                '}';
    }
}
