package com.gov.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gov.vaccine.entity.SignUpEntity;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public SignUpEntity getEntityByUsername(String userName) {
		System.out.println("Invoked getEntityByUsernameAndPassword()");
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("getEntityByUsernameAndPassword");
			query.setParameter("USERNAME", userName);
			SignUpEntity entity = (SignUpEntity) query.uniqueResult();
			System.out.println("SignUpEntity : -" + entity);
			return entity;
		} catch (HibernateException e) {

		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

		return null;
	}

}
