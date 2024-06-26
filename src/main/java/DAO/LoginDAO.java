package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import server.Controller.HashController;
import server.ObjectGson.GsonForClient.CL_CheckLogin;
import server.ObjectGson.GsonForClient.CL_Login;
import server.ObjectGson.GsonForServer.SV_User;
import util.HibernateUtil;

public class LoginDAO {
    public static CL_CheckLogin checkLogin(CL_Login cl_login){
        CL_CheckLogin clCheckLogin = new CL_CheckLogin();
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<SV_User> query = session.createQuery("FROM SV_User WHERE username = :username and password = :password ", SV_User.class);
            query.setParameter("username",cl_login.getUsername());
            query.setParameter("password", HashController.sha256(cl_login.getPassword()));

            SV_User sv_user = query.uniqueResult();
            if (sv_user != null){
                clCheckLogin.setCheck(true);
                clCheckLogin.setIdUser(sv_user.getUserId());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return clCheckLogin;
    }
}
