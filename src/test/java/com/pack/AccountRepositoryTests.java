package com.pack;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pack.model.Account;
import com.pack.model.Corporate;
import com.pack.repository.AccountRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepositoryTests {

	static Corporate corporate = null;

	@Autowired
	AccountRepository accountRepository;

	static Account account;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corporate = new Corporate(1);
		account = new Account(101, corporate, "virtusa1", "Hyderabad", "INR", 12340, true);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		corporate = null;
		account = null;
	}

	@Test
	public void saveAccountTests() {
		Account accObj = accountRepository.save(account);
		Assertions.assertEquals(accObj.getAccountNumber(), account.getAccountNumber());
	}

	@Test
	public void findByAccountnumberTests() {
		Account Obj = accountRepository.findByAccountNumber(account.getAccountNumber());
		Assertions.assertEquals(101, Obj.getAccountNumber());
	}

	@Test
	public void deleteAccount() {
		Account obj = accountRepository.findById(account.getAccountNumber()).get();
		obj.setActive(false);
		Account obj2 = accountRepository.save(obj);
		Assertions.assertFalse(obj2.isActive());
	}

}