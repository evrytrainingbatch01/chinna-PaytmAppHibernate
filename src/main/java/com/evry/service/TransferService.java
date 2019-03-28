package com.evry.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.evry.model.Account;
import com.evry.util.HibernateUtil;

public class TransferService {

	public Account transferMoney(long id1,long id2,int balance)
	{
		
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null; 
	       Account account=null;
	       Account account2=null;
	        try {
	        	
	        	tx = session.getTransaction();
	            tx.begin();
	             account=session.get(Account.class, id1);
	             account2=session.get(Account.class, id2);
	             
	            account.setBalance(account.getBalance()-balance);
	            account2.setBalance(account2.getBalance()+balance);
	            session.update(account);
	            session.update(account2);
	            
	            tx.commit();
	            session.get(Account.class, id1);
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
