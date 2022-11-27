package com.example.service;

import com.example.dto.StudentDto;
import com.example.entity.StudentEntity;
import com.example.enums.Gender;
import com.example.enums.Level;
import com.example.exceptions.ObjectLengthIsNotEnough;
import com.example.exceptions.SubjectNotFoundException;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public StudentDto create(StudentDto dto) {
        if (dto.getName().length()<2 || dto.getSurname().length()<2){
            throw new ObjectLengthIsNotEnough("name or surname is very short !!! ");
        }
        if (dto.getPhone().length()<12){
            throw new ObjectLengthIsNotEnough("the phone is short !!!");
        }
        StudentEntity entity=toEntity(dto);
        studentRepository.save(entity);
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }



    private StudentEntity toEntity(StudentDto dto){
        StudentEntity entity=new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        entity.setAge(dto.getAge());
        entity.setLevel(Level.valueOf(dto.getLevel()));     //todo LEVEL tipli enumga o`tkazib oldim stringdan
        entity.setGender(Gender.valueOf(dto.getGender()));
        entity.setCreatedDate(LocalDateTime.now());
        return entity;
    }

    public List<StudentDto> getAllStudent() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        Iterable<StudentEntity> all = studentRepository.findAll();

        all.forEach(studentEntity -> studentDtoList.add(toDto(studentEntity)));

        return studentDtoList;
    }

    private StudentDto toDto(StudentEntity entity) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setGender(entity.getSurname());
        dto.setAge(entity.getAge());
        dto.setPhone(entity.getPhone());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLevel(entity.getLevel().name());//todo enumdan Stringnga o`tish
        dto.setGender(entity.getGender().name());
        return dto;
    }

    public StudentDto getById(Integer id) {
        Optional<StudentEntity> optional=studentRepository.findById(id);
        StudentDto dto=toDto(optional.get());
        return dto;
    }


    public String deleteById(Integer id) {
        Optional<StudentEntity> entity=studentRepository.findById(id);
        if (entity.isEmpty()){
            throw new SubjectNotFoundException(" Student is not found? ");
        }
        studentRepository.deleteById(id);
        return " Successfully deleted !!! ";
    }

//    public StudentDto getStudentByEachFileds(StudentDto dto) {
//        Optional<StudentEntity> optional=studentRepository.getByNameAndSurnameAndAge(dto.getName(),dto.getSurname(),dto.getAge());
//        if (optional.isEmpty()){
//            throw new SubjectNotFoundException("Object is not found !!! ");
//        }
//        StudentEntity entity=optional.get();
//        StudentDto dto1=toDto(entity);
//        return dto1;
//    }

//    public List<StudentDto> getStudentsBetweenGivenDate(LocalDateTime localDate1, LocalDateTime localDate2) {
//        String year=String.valueOf(localDate1.getYear());
//        String month=String.valueOf(localDate1.getMonth());
//        String day=String.valueOf(localDate1.getDayOfMonth());
//        LocalDateTime localDT1 = LocalDateTime.parse(year+"-"+month+"-"+day+" "+"00:00:00");
//
//        String year1=String.valueOf(localDate2.getYear());
//        String month1=String.valueOf(localDate2.getMonth());
//        String day1=String.valueOf(localDate2.getDayOfMonth());
//        LocalDateTime localDT2 = LocalDateTime.parse(year+"-"+month+"-"+day+" "+"00:00:00");
//
//        List<StudentEntity> entities=studentRepository.findByCreatedDateBetween(localDate1,localDate2);
//
//        List<StudentDto> dtos=new ArrayList<>();
//        for (StudentEntity entity : entities) {
//            dtos.add(toDto(entity));
//        }
//        return dtos;
//    }

    //todo exercise7
//    public List<StudentDto> getStudentListByGivenDate(LocalDate localDate){
//        List<StudentEntity> entities=studentRepository.findAllByDate(localDate);
//        return entities;
//    }


}
