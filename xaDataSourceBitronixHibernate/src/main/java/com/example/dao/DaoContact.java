package com.example.dao;

import java.util.List;

import com.example.model.primary.Account;
import com.example.model.secondary.Contact;

public interface DaoContact {

	Contact insert(Contact contact);

	Contact update(Contact contact);

	void delete(Contact account);

	List<Contact> findAll();

	Account findAccountById(Long id);
	

}
