package com.evry.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.evry.model.Account;
import com.evry.model.User;
import com.evry.util.HibernateUtil;

public class AccountService {

	public boolean addMoney(Account account){
		
	     Session session = HibernateUtil.getSessionFactory().openSession();
	     
	    if(isAccountExists(account)) return false;  
	     
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	        
	         session.saveOrUpdate(account);       
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

	private boolean isAccountExists(Account account) {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		
	     boolean result = false;
	     Transaction tx = null;
	     try{
	         tx = session.getTransaction();
	         tx.begin();
	         Query query = session.createQuery("from Account where accountNumber='"+account.getAccountNumber()+"'");
	         Account a = (Account)query.uniqueResult();
	         tx.commit();
	         if(a!=null) result = true;
	     }catch(Exception ex){
	         if(tx!=null){
	             tx.rollback();
	         }
	     }finally{
	         session.close();
	     }
	     return result;
	    
	}
	
	 public List<Account> getListOfAccounts(){
	        List<Account> list = new ArrayList<Account>();
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null;       
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            list = session.createQuery("from Account").list();                       
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return list;
	    }

	
		
	
}
