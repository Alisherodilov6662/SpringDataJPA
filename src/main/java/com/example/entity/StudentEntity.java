package com.example.entity;

import com.example.enums.Gender;
import com.example.enums.Level;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@ToString
@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    @Column(columnDefinition = "varchar(13)",nullable = false )
    private String phone;
    @Enumerated(EnumType.STRING)
    private Level level;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
