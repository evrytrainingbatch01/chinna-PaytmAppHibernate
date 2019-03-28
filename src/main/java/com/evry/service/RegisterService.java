package com.evry.service;

import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.evry.model.User;
import com.evry.util.HibernateUtil;

public class RegisterService {

	public boolean register(User user){
		
	     Session session = HibernateUtil.getSessionFactory().openSession();
	     
	    if(isUserExists(user)) return false;  
	     
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	        ;
	         session.saveOrUpdate(user);       
	         tx.commit();
	     } catch (Exception e) {
	         if (tx != null) {
	             tx.rollback();
	         }
	         e.printStackTrace();
	     } finally {
	         session.close();
	     } 
	     return true;
	}

	private boolean isUserExists(User user) {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		
	     boolean result = false;
	     Transaction tx = null;
	     try{
	         tx = session.getTransaction();
	         tx.begin();
	         Query query = session.createQuery("from User where userId='"+user.getUserId()+"'");
	         User u = (User)query.uniqueResult();
	         tx.commit();
	         if(u!=null) result = true;
	     }catch(Exception ex){
	         if(tx!=null){
	             tx.rollback();
	         }
	     }finally{
	         session.close();
	     }
	     return result;
	    
	}

	
	
}
