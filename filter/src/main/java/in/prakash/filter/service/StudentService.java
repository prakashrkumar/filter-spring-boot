package in.prakash.filter.service;

import in.prakash.filter.dto.Student;
import in.prakash.filter.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentResponseDto createStudent(Student student) {
        StudentResponseDto responseDto=new StudentResponseDto();
        responseDto.setName(student.getName());
        responseDto.setMessage("Student is saved successFully");

         return responseDto;

    }

}
