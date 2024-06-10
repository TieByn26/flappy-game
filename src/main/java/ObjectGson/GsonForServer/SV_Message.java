package ObjectGson.GsonForServer;

public class SV_Message {
    private int userId;
    private String content;

    public SV_Message(int userId, String content) {
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

    @Override
    public String toString() {
        return "SV_Message{" +
                "userId=" + userId +
                ", content='" + content + '\'' +
                '}';
    }
}
