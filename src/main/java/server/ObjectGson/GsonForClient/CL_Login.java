package server.ObjectGson.GsonForClient;

public class CL_Login {
    private String username;
    private String password;

    public CL_Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CL_Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
