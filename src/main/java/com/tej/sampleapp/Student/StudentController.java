package com.tej.sampleapp.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping("list")
    public List<Student> GetStudents(){

        return studentService.GetStudentList();
    }
    @PostMapping
    public  void registerNewStudent(@RequestBody Student student) throws IllegalAccessException {
    studentService.addNewStudent(student);
    }
   @DeleteMapping(path= "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) throws IllegalAccessException {
    studentService.deleteStudent(id);
    }
 @PutMapping(path="{studentId}")
    public void updateStudent(
        @PathVariable("studentId") Long studentId,
        @RequestParam(required = false) String FirstName,
        @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,FirstName,email);
    }


}
