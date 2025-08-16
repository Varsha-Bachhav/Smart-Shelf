package com.varsha.libraryManagement.controllers;

import com.varsha.libraryManagement.dto.IssueBookDtoRequest;
import com.varsha.libraryManagement.dto.ReturnBookDtoRequest;
import com.varsha.libraryManagement.dto.TransactionDto;
import com.varsha.libraryManagement.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/getAllTransactions")
    public ResponseEntity<List<TransactionDto>> getAllTransactions()
    {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getAllTransactions());
    }

    @PostMapping("/issueBook")
    public ResponseEntity<TransactionDto> saveIssuedBook(@RequestBody IssueBookDtoRequest issueBookDtoRequest)
    {
        TransactionDto newTransactionDto = transactionService.issueBookToMember(issueBookDtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransactionDto);
    }

    @PutMapping("/returnBook")
    public ResponseEntity<TransactionDto> returnBook(@RequestBody ReturnBookDtoRequest returnBookDtoRequest)
    {
        TransactionDto transactionDto = transactionService.returnBook(returnBookDtoRequest);
        return ResponseEntity.ok(transactionDto);
    }
}