package com.example.hw21.Repostory;

import com.example.hw21.Model.Teacher;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    //Teacher findTeacherById(Integer Id);
    List<Teacher> findTeacherById (Integer id);
    //Teacher findTeacherByName (Integer id);
}
