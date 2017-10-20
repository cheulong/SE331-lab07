package camt.cbsd.lab05.controller;

import camt.cbsd.lab05.entity.Student;
import camt.cbsd.lab05.service.StudentService;
import camt.cbsd.lab05.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class StudentController {
    StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudents() {

        List<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }
    @PostMapping("/student")
    public ResponseEntity<?> uploadOnlyStudent(@RequestBody Student student){
        System.out.println(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("student/{id}")
    public ResponseEntity getStudent(@PathVariable("id")long id){
        Student student = studentService.findById(id);
        if (student!= null)
            return ResponseEntity.ok(student);
        else
            //http code 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
