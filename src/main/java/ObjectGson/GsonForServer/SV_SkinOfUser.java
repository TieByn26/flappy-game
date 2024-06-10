package ObjectGson.GsonForServer;

public class SV_SkinOfUser {
    private int userId;
    private String birdSkin;
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
