package com.varsha.libraryManagement.service;

import com.varsha.libraryManagement.dto.IssueBookDtoRequest;
import com.varsha.libraryManagement.dto.ReturnBookDtoRequest;
import com.varsha.libraryManagement.dto.TransactionDto;
import com.varsha.libraryManagement.entity.Transaction;
import com.varsha.libraryManagement.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<TransactionDto> getAllTransactions(){
        List<Transaction> alltransactions = transactionRepository.findAll();
        List<TransactionDto> allDtoTransactions = alltransactions.stream().map(transaction -> new TransactionDto(transaction.getMember(),transaction.getMemberType(),transaction.getIssuedBook(),transaction.getIssuedDate(),transaction.getReturnDate(),transaction.getDueDate(),transaction.getStatus())).toList();
        return allDtoTransactions;
    }

    public TransactionDto issueBookToMember(IssueBookDtoRequest issueBookDtorequest)
    {
        Transaction newTransaction = new Transaction();
        newTransaction.setIssuedBook(issueBookDtorequest.getIssuedBook());
        newTransaction.setMember(issueBookDtorequest.getMember());
        newTransaction.setMemberType(issueBookDtorequest.getMemberType());
        newTransaction.setIssuedDate(issueBookDtorequest.getIssuedDate());
        newTransaction.setDueDate(issueBookDtorequest.getDueDate());
        newTransaction.setStatus(issueBookDtorequest.getStatus());

        transactionRepository.save(newTransaction);

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setMember(newTransaction.getMember());
        transactionDto.setMemberType(newTransaction.getMemberType());
        transactionDto.setIssuedBook(newTransaction.getIssuedBook());
        transactionDto.setStatus(newTransaction.getStatus());
        transactionDto.setIssuedDate(newTransaction.getIssuedDate());
        transactionDto.setDueDate(newTransaction.getDueDate());
        return transactionDto;

    }

    public TransactionDto returnBook(ReturnBookDtoRequest returnBookDtoRequest)
    {
        Transaction transaction = transactionRepository.findByMemberAndIssuedBook(returnBookDtoRequest.getMember(), returnBookDtoRequest.getIssuedBook()).orElseThrow(()-> new IllegalArgumentException("Record Not Found"));
        transaction.setReturnDate(returnBookDtoRequest.getReturnDate());
        transaction.setStatus("RETURNED");
        transaction = transactionRepository.save(transaction);

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setMember(transaction.getMember());
        transactionDto.setReturnDate(transaction.getReturnDate());
        transactionDto.setStatus(transaction.getStatus());
        transactionDto.setIssuedBook(transaction.getIssuedBook());
        transactionDto.setMemberType(transaction.getMemberType());
        transactionDto.setDueDate(transaction.getDueDate());
        transactionDto.setIssuedDate(transaction.getIssuedDate());

        return transactionDto;
    }


}
