package com.gov.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gov.vaccine.entity.SignUpEntity;

@Repository
public class SignUpDAOImpl implements SignUpDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public boolean saveSignUpEntity(SignUpEntity signUpEntity) {
		System.out.println("Invoked saveSignUpEntity() ");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(signUpEntity);
			session.getTransaction().commit();
			System.out.println("Saved : " + signUpEntity);
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
