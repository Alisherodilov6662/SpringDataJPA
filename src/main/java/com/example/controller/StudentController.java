package com.example.controller;

import com.example.dto.StudentDto;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping("")
   public ResponseEntity<?> create(@RequestBody StudentDto dto){
        StudentDto dto1=studentService.create(dto);
        return ResponseEntity.ok(dto1);
    }

    //todo addAllStudents method

    @GetMapping("")
    public ResponseEntity<?> getAllStudentLists(){
        List<StudentDto> studentDtos=studentService.getAllStudent();
        return ResponseEntity.ok(studentDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id){
        StudentDto dto=studentService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("")

    @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteStudentById(@PathVariable("id") Integer id){
        String result=studentService.deleteById(id);
        return ResponseEntity.ok(result);
    }

//    @GetMapping("")
//    public ResponseEntity<?> getStudentByEachField(@RequestBody StudentDto dto){
//       StudentDto dto1=studentService.getStudentByEachFileds(dto);
//       return ResponseEntity.ok(dto1);
//    }

//    @GetMapping("/{localDateTime1}/{localDateTime2}")
//    public ResponseEntity<?> getStudentsBetweenGivenDate(@PathVariable("localDateTime1") LocalDateTime localDate1, @PathVariable ("localDateTime2")  LocalDateTime localDate2){
//        List<StudentDto> dtos=studentService.getStudentsBetweenGivenDate(localDate1,localDate2);
//        return ResponseEntity.ok(dtos);
//    }

}
