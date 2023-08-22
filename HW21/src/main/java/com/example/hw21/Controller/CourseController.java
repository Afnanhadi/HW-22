package com.example.hw21.Controller;

import com.example.hw21.Model.Course;
import com.example.hw21.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/Course")
@RequiredArgsConstructor
public class CourseController {
    private  final CourseService courseService;

    @GetMapping("/get")
    private ResponseEntity getAllCourse(){
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.AddCourse(course);
        return ResponseEntity.status(200).body("add Course");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateCourse(@RequestBody @Valid Course course, @PathVariable Integer id){
        courseService.update(id, course);
        return ResponseEntity.status(200).body("Update Course");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable  Integer id){
        courseService.delete(id);
        return ResponseEntity.status(200).body("Delete Course");
    }
    @PutMapping("/{Course_Id}/assign/{Teacher_Id}")
    public ResponseEntity assignTeacherIdCourse(@PathVariable  Integer Course_Id,@PathVariable  Integer Teacher_Id){
       courseService.assignTeacherIdCourse(Course_Id,Teacher_Id);
        return ResponseEntity.status(200).body("assing done");
    }
    @GetMapping("/SearchNameTeacher/{Id}")
    public ResponseEntity SearchNameTeacher(@PathVariable Integer Id){
        return ResponseEntity.status(200).body(courseService.SearchNameTeacher(Id));
    }


}
