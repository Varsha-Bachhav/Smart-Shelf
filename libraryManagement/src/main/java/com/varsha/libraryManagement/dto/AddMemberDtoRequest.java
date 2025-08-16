package com.varsha.libraryManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AddMemberDtoRequest {
    private String name;
    private String email;
    private String phNumber;
    private String type;
    private String expiry;
    private String address;
}
