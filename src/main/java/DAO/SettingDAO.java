package DAO;

import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import server.ObjectGson.GsonForClient.CL_IdUser;
import server.ObjectGson.GsonForServer.SV_Level;
import server.ObjectGson.GsonForServer.SV_Score;
import server.ObjectGson.GsonForServer.SV_Sound;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class SettingDAO {
    public SettingDAO() {
    }
    public static void newAccount (int idUser){

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            SV_Sound sv_sound = new SV_Sound();
            sv_sound.setIdUser(idUser);
            sv_sound.setSound(1);
            Transaction transaction = session.beginTransaction();
            session.save(sv_sound);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void newLevel(int idLevel) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            SV_Level sv_level = new SV_Level();
            sv_level.setIdUser(idLevel);
            sv_level.setLevel(1);
            session.save(sv_level);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void updateSound(SV_Sound sv_Sound){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(sv_Sound);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateLevel(SV_Level sv_level){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(sv_level);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SV_Sound getSound(CL_IdUser cl_idUser){
        SV_Sound sv_sound = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SV_Sound> query = session.createQuery("from SV_Sound where idUser = : idUser  ", SV_Sound.class);
            query.setParameter("idUser", cl_idUser.getIdUser());
            sv_sound = query.uniqueResult();

        } catch (Exception e){
            e.printStackTrace();
        }
        return sv_sound;
    }

    public static SV_Level getLevel(CL_IdUser cl_idUser){
        SV_Level sv_level = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SV_Level> query = session.createQuery("from SV_Level where idUser = : idUser  ", SV_Level.class);
            query.setParameter("idUser", cl_idUser.getIdUser());
            sv_level = query.uniqueResult();

        } catch (Exception e){
            e.printStackTrace();
        }
        return sv_level;
    }

}
