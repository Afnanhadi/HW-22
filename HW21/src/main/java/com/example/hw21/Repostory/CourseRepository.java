package com.example.hw21.Repostory;

import com.example.hw21.Model.Course;
import com.example.hw21.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findAllById (Integer id);

}
