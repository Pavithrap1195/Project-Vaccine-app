package com.gov.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gov.vaccine.controller.LoginController;
import com.gov.vaccine.entity.SignUpEntity;

@Repository
public class ResetPasswordDAOImpl implements ResetPasswordDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public boolean updatePasswordByUsername(String password, String userName) {
		System.out.println("Invoked updatePasswordByUsername()");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("updatePasswordByUsername");
			query.setParameter("PASSWORD", password);
			query.setParameter("USERNAME", userName);
			query.setParameter("ATTEMPTS", 0);
			int updated = query.executeUpdate();
			System.out.println("Updated :- " + updated);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return false;
	}
}
