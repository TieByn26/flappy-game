package ObjectGson.GsonForServer;

public class SV_Message {
    private int idMess;
    private int userId;
    private String content;

    public SV_Message(int idMess, int userId, String content) {
        this.idMess = idMess;
        this.userId = userId;
        this.content = content;
    }

    public SV_Message() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdMess() {
        return idMess;
    }

    public void setIdMess(int idMess) {
        this.idMess = idMess;
    }

    @Override
    public String toString() {
        return "SV_Message{" +
                "idMess=" + idMess +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                '}';
    }
}