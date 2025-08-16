package com.varsha.libraryManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private long id;
    private String name;
    private String email;
    private String phNumber;
    private String type;
    private String expiry;
    private String address;
}
