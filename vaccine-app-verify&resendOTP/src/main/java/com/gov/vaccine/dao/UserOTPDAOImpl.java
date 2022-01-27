package com.gov.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gov.vaccine.entity.UserOTPEntity;

@Repository
public class UserOTPDAOImpl implements UserOTPDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public boolean saveUserOTP(UserOTPEntity userOTPEntity) {
		System.out.println("Invoked saveUserOTP() in DAOImpl");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			
			session.save(userOTPEntity);
			
			session.getTransaction().commit();
			System.out.println("UserOTPEntity :- " + userOTPEntity);
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

	@Override
	public int getUserOTPByEmailID(String emailID) {
		System.out.println("Invoked getUserOTPByEmailID() in DAOImpl");
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("UserOTPEntity.getUserOTPByEmailID");
			query.setParameter("EMAILID", emailID);
			System.out.println("after parameter");
			Object result = query.setMaxResults(1).uniqueResult();
			System.out.println("After unique result");
			Integer otp = (Integer) result;
			if (otp != null) {
				System.out.println("EmailID found");
				return otp;
			} else {
				System.out.println("EmailID not found in data base");
				return 0;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return 0;
	}

}
