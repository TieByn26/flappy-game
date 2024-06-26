package server.ObjectGson.GsonForServer;

public class SV_Check {
    private Boolean check;

    public SV_Check(Boolean check) {
        this.check = check;
    }

    public SV_Check() {
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "SV_Check{" +
                "check=" + check +
                '}';
    }
}
