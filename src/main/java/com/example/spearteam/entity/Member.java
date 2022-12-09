package com.example.spearteam.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "The full_name is missing !")
    @Column(nullable = false)
    private String fullName;

    @NotNull(message = "The email is missing !")
    @Column(nullable = false)
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date dob;
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
