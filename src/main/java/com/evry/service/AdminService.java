package com.evry.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.evry.model.Admin;
import com.evry.util.HibernateUtil;

public class AdminService {

	public boolean authenticateUser(String userId, String password) {
        Admin admin= getUserByUserId(userId);         
        if(admin!=null && admin.getUserId().equals(userId) && admin.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
 
    public Admin getUserByUserId(String userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Admin admin = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Admin where userId='"+userId+"'");
            admin = (Admin)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return admin;
}
}
