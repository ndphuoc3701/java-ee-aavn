package com.example.spearteam.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String fullName;
    private String email;
    private String phone;
    private String homeTown;
    private String university;
}
