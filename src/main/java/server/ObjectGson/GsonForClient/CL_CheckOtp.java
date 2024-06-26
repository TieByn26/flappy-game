package server.ObjectGson.GsonForClient;

public class CL_CheckOtp {
    private String username;

    public CL_CheckOtp(String username) {
        this.username = username;
    }

    public CL_CheckOtp() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CL_CheckOtp{" +
                "username='" + username + '\'' +
                '}';
    }
}
