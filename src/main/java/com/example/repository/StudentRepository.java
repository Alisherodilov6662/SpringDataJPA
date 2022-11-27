package com.example.repository;

import com.example.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity,Integer> {


//    Optional<StudentEntity> getByNameAndSurnameAndAge(String name, String surname, Integer age);

//    List<StudentEntity> findAllByDate(LocalDate localDate);

//    List<StudentEntity> findByCreatedDateBetween(LocalDateTime localDT1, LocalDateTime localDT2);
}
