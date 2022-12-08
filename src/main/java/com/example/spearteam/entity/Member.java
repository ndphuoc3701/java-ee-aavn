package com.example.spearteam.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;

    @NotNull(message = "The full_name is missing !")
    @Column(nullable = false)
    private String fullName;

    @NotNull(message = "The email is missing !")
    @Column(nullable = false)
    private String email;

    @NotNull(message = "The phone is missing !")
    @Column(nullable = false, length = 10)
    @Size(max = 10)
    private String phone;


    @Column(length = 50)
    @Size(max = 50)
    private String homeTown;

    @Column(length = 50)
    @Size(max = 50)
    private String university;

}
