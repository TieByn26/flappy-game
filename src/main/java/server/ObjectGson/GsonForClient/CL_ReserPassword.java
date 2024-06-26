package server.ObjectGson.GsonForClient;

public class CL_ReserPassword {
    private String username;
    private String email;
    private String newpassword;

    public CL_ReserPassword(String username, String email, String newpassword) {
        this.username = username;
        this.email = email;
        this.newpassword = newpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    @Override
    public String toString() {
        return "CL_ReserPassword{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", newpassword='" + newpassword + '\'' +
                '}';
    }
}
