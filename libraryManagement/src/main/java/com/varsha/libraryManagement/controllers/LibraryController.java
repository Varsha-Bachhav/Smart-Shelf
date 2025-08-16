package com.varsha.libraryManagement.controllers;

import com.varsha.libraryManagement.dto.LibraryDetailsDto;
import com.varsha.libraryManagement.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LibraryController {
    private final LibraryService libraryService;
    @GetMapping("/libraryDetails")
    public ResponseEntity<LibraryDetailsDto> getLibraryDetails(){
        LibraryDetailsDto libraryDetailsDto = libraryService.getLibraryDetails();
        return ResponseEntity.ok(libraryDetailsDto);
    }
}
