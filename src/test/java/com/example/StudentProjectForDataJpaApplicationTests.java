package com.example;

import com.example.dto.CourseDto;
import com.example.dto.StudentDto;
import com.example.service.CourseService;
import com.example.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class StudentProjectForDataJpaApplicationTests {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;


	@Test
	void contextLoads() {
//		System.out.println(studentService.getAllStudents());
//      studentService.deleteById(1);

//		List<StudentDto> studentsBetweenGivenDate = studentService.getStudentsBetweenGivenDate(LocalDateTime.now(), LocalDateTime.now());
//		System.out.println(studentsBetweenGivenDate);
//		CourseDto dto=new CourseDto();
//		dto.setName(" matematika ");
//		dto.setPrice(250d);
//		dto.setDuration(45);
//
//	courseService.create(dto);

		courseService.getCourseById(1);




	}

}
