package server.ObjectGson.GsonForServer;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class SV_Message {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idMess")
    private int idMess;
    @Column(name = "userId")
    private int userId;
    @Column(name = "content")
    private String content;

    public SV_Message(int idMess, int userId, String content) {
        this.idMess = idMess;
        this.userId = userId;
        this.content = content;
    }

    public SV_Message() {
    }

    public int getIdMess() {
        return idMess;
    }

    public void setIdMess(int idMess) {
        this.idMess = idMess;
    }


    public String getContent() {
        return content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
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
