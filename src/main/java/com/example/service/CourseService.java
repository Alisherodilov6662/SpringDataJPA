package com.example.service;

import com.example.dto.CourseDto;
import com.example.entity.CourseEntity;
import com.example.exceptions.SubjectNotFoundException;
import com.example.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseDto create(CourseDto dto) {
        CourseEntity entity=toEntity(dto);
        courseRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }
    
    public CourseDto getCourseById(Integer id){
        Optional<CourseEntity>optional=courseRepository.findById(id);
        if (optional.isEmpty()){
            throw new SubjectNotFoundException("Object is not found ?");
        }
        CourseEntity entity= optional.get();
        CourseDto dto=toDto(entity);
        return dto;
    }



    private CourseDto toDto(CourseEntity entity) {
        CourseDto dto=new CourseDto();
        dto.setName(entity.getName());
        dto.setDuration(entity.getDuration());
        dto.setPrice(entity.getPrice());
        dto.setCreateDate(entity.getCreatedDate());
        return dto;
    }

    private CourseEntity toEntity(CourseDto dto){
        CourseEntity entity=new CourseEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDuration(dto.getDuration());
        entity.setCreatedDate(LocalDate.now());
        return entity;
    }
}
