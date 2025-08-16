package com.varsha.libraryManagement.controllers;

import com.varsha.libraryManagement.dto.AddMemberDtoRequest;
import com.varsha.libraryManagement.dto.AddStudentDtoRequest;
import com.varsha.libraryManagement.dto.MemberDto;
import com.varsha.libraryManagement.dto.StudentDto;
import com.varsha.libraryManagement.entity.Member;
import com.varsha.libraryManagement.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/getAllMembers")
    public List<MemberDto> getAllMembers(){
        return memberService.getAllMembers();
    }
//
//    @GetMapping("/getAllStudents/{id}")
//    public StudentDto getStudent(@PathVariable Long id)
//    {
//        return memberService.getStudent(id);
//    }
//
    @PostMapping("/member")
    public ResponseEntity<MemberDto> createNewMember(@RequestBody AddMemberDtoRequest addMemberDtoRequest)
    {
        MemberDto memberDto = memberService.createNewMember(addMemberDtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberDto);
    }
}
