package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.primary.Account;
import com.example.model.secondary.Contact;

@Repository
public class DaoContactImpl implements DaoContact {

	@Qualifier("sessionFactorySecondary")
	@Autowired
	private SessionFactory sessionFactory;

	public Contact insert(Contact contact) {
		getSession().save(contact);
		return contact;
	}

	public Contact update(Contact contact) {
		getSession().update(contact);
		return contact;
	}

	public void delete(Contact account) {
		getSession().delete(account);
	}

	public List<Contact> findAll() {
		return getSession().createCriteria(Account.class).list();
	}

	public Account findAccountById(Long id) {
		return (Account) getSession().get(Contact.class, id);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
