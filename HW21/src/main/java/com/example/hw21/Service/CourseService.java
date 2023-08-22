package com.example.hw21.Service;

import com.example.hw21.Api.ApiException;
import com.example.hw21.Model.Course;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repostory.CourseRepository;
import com.example.hw21.Repostory.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    public void AddCourse(Course course){
        courseRepository.save(course);
    }
    public void update(Integer id, Course course){
        Course course1=courseRepository.getReferenceById(id);

        if (course1 ==null){
            throw new ApiException("not found");
        }
        course1.setName(course.getName());
        course1.setTeacher(course.getTeacher());
        courseRepository.save(course1);
    }
    public void delete(Integer id){
       Course course=courseRepository.getReferenceById(id);
        if (course ==null){
            throw new ApiException("not found");
        }
        courseRepository.delete(course);
    }
    public void assignTeacherIdCourse(Integer Course_Id,Integer Teacher_Id){
        Teacher  teacher=teacherRepository.getReferenceById(Teacher_Id);
        Course course=courseRepository.getReferenceById(Course_Id);
        if (teacher==null || course==null){
            throw new ApiException("not found assign");

        }
        course.setTeacher(teacher);
        courseRepository.save(course);

    }
   public List<Course> SearchNameTeacher(Integer Id){
        List<Course> courses=courseRepository.findAllById(Id);

       if (courses ==null){
           throw new ApiException("not found");
       }

       return courses;

   }
}
