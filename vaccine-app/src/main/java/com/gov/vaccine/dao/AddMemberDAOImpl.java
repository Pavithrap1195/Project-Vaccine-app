package com.gov.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gov.vaccine.entity.AddMemberEntity;

@Repository
public class AddMemberDAOImpl implements AddMemberDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public boolean saveMemberDetails(AddMemberEntity addMemberEntity) {
		System.out.println("Invoked saveMemberDetails() ");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(addMemberEntity);
			session.getTransaction().commit();
			System.out.println("Entity :- " + addMemberEntity);
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
