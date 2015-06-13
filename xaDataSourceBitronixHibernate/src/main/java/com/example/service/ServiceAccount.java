package com.example.service;

import java.util.List;

import com.example.model.primary.Account;
import com.example.model.secondary.Contact;

public interface ServiceAccount {

	List<Account> findAll();
	
	void save(Account account, Contact contact);

}
