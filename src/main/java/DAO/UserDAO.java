package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import server.Controller.HashController;
import server.ObjectGson.GsonForClient.CL_ChangePass;
import server.ObjectGson.GsonForClient.CL_RegisterInformation;
import server.ObjectGson.GsonForServer.SV_ListScore;
import server.ObjectGson.GsonForServer.SV_ListUserInfor;
import server.ObjectGson.GsonForServer.SV_User;
import server.ObjectGson.GsonForServer.SV_UserInfor;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAO {
    public static int registerAccount(CL_RegisterInformation cl_registerInformation){
        int idUser = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //bat dau mot phien giao dich
            Transaction transaction = session.beginTransaction();
            SV_User sv_user = new SV_User();
            //set du lieu co doi tuong
            sv_user.setUsername(cl_registerInformation.getUsername());
            sv_user.setPassword(HashController.sha256(cl_registerInformation.getPassword()));
            sv_user.setEmail(cl_registerInformation.getEmail());
            //luu cac thay doi
            session.save(sv_user);
            //thuc hien commit vinh vien len database
            transaction.commit();

            idUser = sv_user.getUserId();
        } catch (Exception e){
            e.printStackTrace();
        }
        return idUser;
    }
    public static void newInforUser(int idUser, CL_RegisterInformation cl_registerInformation){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            SV_UserInfor svUserInfor = new SV_UserInfor();
            //set du lieu
            svUserInfor.setUserId(idUser);
            svUserInfor.setUsername(cl_registerInformation.getUsername());
            svUserInfor.setIdSkin(1);

            session.save(svUserInfor);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getMailByUsername(String username){
        String email = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<SV_User> query = session.createQuery("from SV_User where username = :username", SV_User.class);
            query.setParameter("username",username);
            SV_User sv_user = query.uniqueResult();
            if (sv_user != null){
                email = sv_user.getEmail();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return email;
    }
    public static void changePassword(CL_ChangePass cl_changePass){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<SV_User> query = session.createQuery("update SV_User set password = :password where username = :username");
            query.setParameter("password",HashController.sha256(cl_changePass.getNewPass()));
            query.setParameter("username",cl_changePass.getUsername());

            int result = query.executeUpdate();
            transaction.commit();

            System.out.println("Co "+result+" dong duoc thay doi");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static SV_ListUserInfor getTop3UserInfor(SV_ListScore sv_listScore) {
        SV_ListUserInfor sv_listUserInfor = new SV_ListUserInfor();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SV_UserInfor> query = session.createQuery("FROM SV_UserInfor WHERE userId IN (:userIds)", SV_UserInfor.class);
            query.setParameter("userIds", Arrays.asList(sv_listScore.getListScore().get(0).getUserId(),
                    sv_listScore.getListScore().get(1).getUserId(),
                    sv_listScore.getListScore().get(2).getUserId()));
            // Lấy danh sách kết quả
            List<SV_UserInfor> resultList = query.getResultList();
            sv_listUserInfor.setListUserInfor(new ArrayList<>(resultList));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sv_listUserInfor;
    }
    public static SV_UserInfor getUserInforById(int userId) {
        SV_UserInfor sv_userInfor = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SV_UserInfor> query = session.createQuery("FROM SV_UserInfor WHERE userId = :userId", SV_UserInfor.class);
            query.setParameter("userId", userId);

            // Thực hiện truy vấn và lấy kết quả
            sv_userInfor = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sv_userInfor;
    }
    public static SV_ListUserInfor getAllUser(){
        SV_ListUserInfor sv_listUserInfor = new SV_ListUserInfor();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SV_UserInfor> query = session.createQuery("from SV_UserInfor", SV_UserInfor.class);
            List<SV_UserInfor> list = query.getResultList();

            sv_listUserInfor.setListUserInfor(new ArrayList<>(list));
        }catch (Exception e){
            e.printStackTrace();
        }
        return sv_listUserInfor;
    }
}