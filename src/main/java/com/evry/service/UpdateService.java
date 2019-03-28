package com.evry.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.evry.model.Account;
import com.evry.util.HibernateUtil;

public class UpdateService {

	public Account addBalance(long id,int balance)
	{
		
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null; 
	        Account account=null;
	        try {
	        	
	        	tx = session.getTransaction();
	            tx.begin();
	             account=session.get(Account.class, id);
	            account.setBalance(account.getBalance()+balance);
	            session.update(account);
	            
	            tx.commit();
	            session.get(Account.class, id);
	        }
	        catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
			return account;
			
	}
}
