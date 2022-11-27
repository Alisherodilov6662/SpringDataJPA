package com.example.dto;

import com.example.enums.Gender;
import com.example.enums.Level;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@ToString
@Getter
@Setter
public class StudentDto {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String level;  //todo bu stringdami yoki enumda
    private Integer age;
    private String gender;
    private LocalDateTime createdDate;
}

