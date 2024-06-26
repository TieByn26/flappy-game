package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import server.ObjectGson.GsonForClient.CL_IdUser;
import server.ObjectGson.GsonForServer.SV_ListScore;
import server.ObjectGson.GsonForServer.SV_Score;
import server.ObjectGson.GsonForServer.SV_UserInfor;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {
    public static void newUser(int userId, SV_UserInfor sv_userInfor){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            SV_Score score = new SV_Score();
            score.setUserId(userId);
            score.setScore("0");


            session.save(score);

            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void updateScores(SV_Score sv_score){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            SV_Score score = session.get(SV_Score.class, sv_score.getUserId());

            score.setScore(sv_score.getScore());
            session.update(score);

            transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SV_ListScore getTop3Scores(){
        SV_ListScore sv_listScore = new SV_ListScore();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SV_Score> query = session.createQuery("from SV_Score order by CAST(score AS integer) desc", SV_Score.class);
            query.setMaxResults(3);

            List<SV_Score> resultList = query.list();
            sv_listScore.setListScore(new ArrayList<>(resultList));
        } catch (Exception e){
            e.printStackTrace();
        }
        return sv_listScore;
    }
    public static SV_Score getScoreOfUser(SV_Score svscore){
        SV_Score sv_score = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SV_Score> query = session.createQuery("from SV_Score where userId = :idUser", SV_Score.class);
            query.setParameter("idUser",svscore.getUserId());
            sv_score = query.uniqueResult();
        } catch (Exception e){
            e.printStackTrace();
        }
        return sv_score;
    }
}
