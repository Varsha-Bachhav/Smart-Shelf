package com.varsha.libraryManagement.service;

import com.varsha.libraryManagement.dto.LibraryDetailsDto;
import com.varsha.libraryManagement.repository.BookRepository;
import com.varsha.libraryManagement.repository.MemberRepository;
import com.varsha.libraryManagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    public LibraryDetailsDto getLibraryDetails()
    {
        long totalBooks = bookRepository.count();
        long totalMembers = memberRepository.count();
        long totalStudents = studentRepository.count();
        LibraryDetailsDto libraryDetailsDto = new LibraryDetailsDto();
        libraryDetailsDto.setTotalBooks(totalBooks);
        libraryDetailsDto.setActiveMembers(totalMembers+totalStudents);
        libraryDetailsDto.setOverdueBooks(150);
        libraryDetailsDto.setBooksCheckedOut(120);
        return libraryDetailsDto;

    }
}

