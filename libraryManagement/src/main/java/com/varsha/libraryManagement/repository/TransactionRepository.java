package com.varsha.libraryManagement.repository;

import com.varsha.libraryManagement.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findByMemberAndIssuedBook(String member, String issuedBook);
}
