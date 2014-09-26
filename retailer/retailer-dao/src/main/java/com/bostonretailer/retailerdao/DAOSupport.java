/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class DAOSupport {

	private static SessionFactory sessionFactory;
	public static ThreadLocal<Session> localSession = new ThreadLocal<>();

	protected DAOSupport() {
	}

	/* Get a Session object */
	public static Session getSession() {
		/* Try to get an existing open session, else open a new session */
		Session session = localSession.get();
		if (session == null) {
			session = sessionFactory.openSession();
			localSession.set(session);
		}
		return session;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public static void setSessionFactory(SessionFactory sessionFactory) {
		DAOSupport.sessionFactory = sessionFactory;
	}

	protected void begin() {
		getSession().beginTransaction();
	}

	protected void commit() {
		try {
			getSession().getTransaction().commit();
		} catch (Exception exp) {
			exp.printStackTrace();
			System.out.println(exp.getMessage());
		}
	}

	public static void close() {
		getSession().close();
		localSession.set(null);
	}

	protected void rollback() {
		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			System.out.println("Cannot Close: " + e);
		}
		try {
			getSession().close();
		} catch (HibernateException e) {
			System.out.println("Cannot Close: " + e);
		}
		localSession.set(null);
	}

}