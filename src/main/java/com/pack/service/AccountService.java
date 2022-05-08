package com.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.Account;
import com.pack.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accRepo;

	public List<Account> getAccounts(Long id) {
		return accRepo.findByCorporate_Id(id);
	}

	public Account getAccount(long id) {
		return accRepo.findByAccountNumber(id);
	}

	public void addAccount(Account accBean) {
		accBean.setActive(true);
		accRepo.save(accBean);
	}

	public void closeAccount(long id) {
		Account acc = accRepo.findByAccountNumber(id);
		acc.setActive(false);
		accRepo.save(acc);
	}

}
