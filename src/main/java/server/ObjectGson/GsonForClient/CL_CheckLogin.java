package server.ObjectGson.GsonForClient;

public class CL_CheckLogin {
    private Boolean check = false;
    private int idUser;

    public CL_CheckLogin(Boolean check, int idUser) {
        this.check = check;
        this.idUser = idUser;
    }

    public CL_CheckLogin() {

    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "CL_CheckLogin{" +
                "check=" + check +
                ", idUser=" + idUser +
                '}';
    }
}
