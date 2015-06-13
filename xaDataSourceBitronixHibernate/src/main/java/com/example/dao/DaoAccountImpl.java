package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.model.primary.Account;
import com.example.model.secondary.Contact;


@Repository
public class DaoAccountImpl implements DaoAccount{
	
	@Qualifier("sessionFactoryPrimary")
    @Autowired
    private SessionFactory sessionFactory;
	
	public Account insert(Account account) {
		getSession().save(account);
		return account;
	}
	
	public Account update(Account account) {
		getSession().update(account);
		return account;
	}

	public void delete(Account account) {
		getSession().delete(account);
	}
	
	public List<Account> findAll() {
		return getSession().createCriteria(Account.class).list();
	}

	public Account findAccountById(Long id) {
		return (Account) getSession().get(Account.class, id);
	}

	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	

}
