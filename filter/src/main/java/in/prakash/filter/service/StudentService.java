package in.prakash.filter.service;

import in.prakash.filter.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void createStudent(Student student){

        System.out.println("Student create");
        System.out.println(student.getEmail());
        System.out.println(student.getName());

        try {
            Thread.sleep(2000);
        }
        catch (Exception e){}
    }

}
