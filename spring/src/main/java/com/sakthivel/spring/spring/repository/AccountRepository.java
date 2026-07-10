package com.sakthivel.spring.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sakthivel.spring.spring.dto.AccountSummary;
import com.sakthivel.spring.spring.model.BankAccount;

public interface AccountRepository extends JpaRepository<BankAccount, String>{
	
	@EntityGraph(attributePaths = "transactions")
	@Query("SELECT a FROM BankAccount a")
	List<BankAccount> findAllWithTransactions();
	List<AccountSummary> findAllProjectedBy();
}
