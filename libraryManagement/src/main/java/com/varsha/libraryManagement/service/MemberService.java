package com.varsha.libraryManagement.service;

import com.varsha.libraryManagement.dto.AddMemberDtoRequest;
import com.varsha.libraryManagement.dto.MemberDto;
import com.varsha.libraryManagement.dto.StudentDto;
import com.varsha.libraryManagement.entity.Member;
import com.varsha.libraryManagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberDto> getAllMembers() {
        List<Member> allMembers = memberRepository.findAll();
        List<MemberDto> allDtoMembers = allMembers.stream().map(member -> new MemberDto(member.getId(), member.getName(),member.getEmail(),member.getPhNumber(),member.getType(),member.getExpiry(),member.getAddress())).toList();
        return allDtoMembers;
    }

    public MemberDto createNewMember(AddMemberDtoRequest addMemberDtoRequest) {
        Member newMemberDto = new Member();
        newMemberDto.setName(addMemberDtoRequest.getName());
        newMemberDto.setAddress(addMemberDtoRequest.getAddress());
        newMemberDto.setExpiry(addMemberDtoRequest.getExpiry());
        newMemberDto.setType(addMemberDtoRequest.getType());
        newMemberDto.setEmail(addMemberDtoRequest.getEmail());
        newMemberDto.setPhNumber(addMemberDtoRequest.getPhNumber());

        memberRepository.save(newMemberDto);

        MemberDto memberDto = new MemberDto();
        memberDto.setId(newMemberDto.getId());
        memberDto.setName(newMemberDto.getName());
        memberDto.setExpiry(newMemberDto.getExpiry());
        memberDto.setEmail(newMemberDto.getEmail());
        memberDto.setType(newMemberDto.getType());
        memberDto.setAddress(newMemberDto.getAddress());

        return memberDto;

    }
}
