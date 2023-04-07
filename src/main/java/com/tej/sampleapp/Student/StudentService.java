package com.tej.sampleapp.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> GetStudentList(){
        return studentRepository.findAll();
     /*   return List.of(new Student(
                        1L,
                        "Tej",
                "tej@gmail.com",
                60
                )
        );*/
    }

    public void addNewStudent(Student student) throws IllegalAccessException{
       Optional<Student> studentByEmail= studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalAccessException("Email Taken");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) throws IllegalAccessException {
        studentRepository.existsById(studentId);
       boolean exist= studentRepository.existsById(studentId);
       if(!exist){
           throw new IllegalAccessException("Student with id ="+studentId +"does not exist.");
                          }
       studentRepository.deleteById(studentId);
    }
@Transactional
    public void updateStudent(Long studentId, String name, String email) {
  Student student=studentRepository.findById(studentId).orElseThrow();
   if(name!=null && name.length()>0 && !Objects.equals(student.getFirstName(),name)){
       student.setFirstName(name);
   }
    }
}
