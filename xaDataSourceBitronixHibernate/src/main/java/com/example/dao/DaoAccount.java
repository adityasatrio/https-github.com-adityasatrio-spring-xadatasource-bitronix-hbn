package com.example.dao;

import java.util.List;

import com.example.model.primary.Account;
import com.example.model.secondary.Contact;

public interface DaoAccount {

	Account insert(Account account);

	Account update(Account account);

	void delete(Account account);

	List<Account> findAll();

	Account findAccountById(Long id);
	
}
