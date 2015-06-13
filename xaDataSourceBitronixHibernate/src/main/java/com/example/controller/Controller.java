package com.example.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.primary.Account;
import com.example.model.secondary.Contact;
import com.example.service.ServiceAccount;

public class Controller {
	
	public static void main(String[] args) {
		System.out.println(" ==== ==== Spring JPA Hibernate ==== ====");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/ApplicationContext.xml");
		
		ServiceAccount serviceAccount  = (ServiceAccount) applicationContext.getBean("serviceAccountImpl");

		Account account = new Account();
		account.setAccountNo("99999999999999999999");
		account.setBalance(new BigDecimal("50000"));
		account.setLastPaidOn(new Date());
		
		Contact contact = new Contact();
		contact.setEmail("xatrx@xatrx.com");
		contact.setFirstName("xatrxxatrx");
		contact.setLastName("xatrxxatrx");
		contact.setMiddleInitial("xatrx");
		
		serviceAccount.save(account, contact);
		
//		List<Account> accounts =  serviceAccount.findAll();
//		for(Account account : accounts){
//			System.out.println(account.toString());
//		}
//		
//		accounts =  serviceAccount.findAll("using query");
//		for(Account account : accounts){
//			System.out.println(account.toString());
//		}
		
		((AbstractApplicationContext)applicationContext).registerShutdownHook();
	}

}
