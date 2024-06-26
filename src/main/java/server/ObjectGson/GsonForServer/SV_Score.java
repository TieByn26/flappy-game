package server.ObjectGson.GsonForServer;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class SV_Score {
    @Id
    @Column(name = "userId")
    private int userId;

    @Column(name = "score", nullable = false)
    private String score;

    public SV_Score() {
    }

    public SV_Score(int userId, String score) {
        this.userId = userId;
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "SV_Score{" +
                "userId=" + userId +
                ", score='" + score + '\'' +
                ", sv_userInfor=" +
                '}';
    }
}
