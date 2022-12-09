package com.example.spearteam.service.dto.base;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO<T> {
    private String message;
    private Integer statusCode;

    private T object;
    private List<?> objectList;

    private String createdTime;
}
