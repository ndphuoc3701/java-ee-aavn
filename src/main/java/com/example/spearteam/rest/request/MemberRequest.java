package com.example.spearteam.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {

    private Integer memberId;
    private String fullName;
    private String email;
    private String phone;
    private String homeTown;
    private String university;

}
