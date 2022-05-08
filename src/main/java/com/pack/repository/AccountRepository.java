package com.pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pack.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query(value = "select * from account_setup where corporate_id=?1 and is_active=1", nativeQuery = true)
	public List<Account> findByCorporate_Id(long Corporate_id);

	public Account findByAccountNumber(long accountNumber);
}
