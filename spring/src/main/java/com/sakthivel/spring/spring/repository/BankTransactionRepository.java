package com.sakthivel.spring.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakthivel.spring.spring.model.BankTransaction;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long>{

}
