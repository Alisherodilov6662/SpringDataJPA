package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
public class CourseDto {
    private Integer id;
    private String name;
    private Double price;
    private Integer duration;
    private LocalDate createDate;
}
