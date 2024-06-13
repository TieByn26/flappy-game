package ObjectGson.GsonForServer;

import java.util.Set;

public class SV_UserInfor {
    private int userId;
    private String username;
    private int idSkin;
    private Set<SV_Score> sv_scores;

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
                ", sv_scores=" + sv_scores +
                '}';
    }
}
