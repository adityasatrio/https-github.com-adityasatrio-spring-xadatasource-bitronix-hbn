package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DaoAccount;
import com.example.dao.DaoContact;
import com.example.model.primary.Account;
import com.example.model.secondary.Contact;

@Service
public class ServiceAccountImpl implements ServiceAccount {

	@Autowired
	private DaoAccount daoAccount;
	
	@Autowired
	private DaoContact daoContact;

	public List<Account> findAll() {
		return daoAccount.findAll();
	}

	@Override
	@Transactional
	public void save(Account account, Contact contact) {
		daoContact.insert(contact);
		daoAccount.insert(account);
		throw new RuntimeException("DDOOORR");
	}

}
