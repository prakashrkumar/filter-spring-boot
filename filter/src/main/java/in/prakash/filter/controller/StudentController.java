package in.prakash.filter.controller;

import in.prakash.filter.dto.Student;
import in.prakash.filter.dto.StudentResponseDto;
import in.prakash.filter.service.StudentService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final ServletResponse servletResponse;
    StudentService studentService;
    public StudentController(StudentService studentService, ServletResponse servletResponse){
        this.studentService=studentService;
        this.servletResponse = servletResponse;
    }
    @PostMapping
    public ResponseEntity<StudentResponseDto>createStudent(@RequestBody Student student, ServletRequest servletRequest){

      StudentResponseDto responseDto= studentService.createStudent(student);
return ResponseEntity.ok(responseDto);
    }


}
