package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import server.ObjectGson.GsonForServer.SV_ListMessage;
import server.ObjectGson.GsonForServer.SV_Message;
import util.HibernateUtil;


import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    public static SV_ListMessage getAllMessage(){
        SV_ListMessage sv_listMessage = new SV_ListMessage();
        try(Session session= HibernateUtil.getSessionFactory().openSession()) {
            Query<SV_Message> query = session.createQuery("from SV_Message ", SV_Message.class);
            List <SV_Message> list = query.list();

            sv_listMessage.setListMess(new ArrayList<>(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sv_listMessage;
    }
    public static void updateMess(SV_Message svMessage){
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction= session.beginTransaction();

            SV_Message sv_message = new SV_Message();
            sv_message.setContent(svMessage.getContent());
            sv_message.setUserId(svMessage.getUserId());
            session.save(sv_message);

            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}