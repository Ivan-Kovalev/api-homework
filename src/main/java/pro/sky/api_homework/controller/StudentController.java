package pro.sky.api_homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.api_homework.model.Student;
import pro.sky.api_homework.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}") // GET http://localhost:8080/student/7
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = service.find(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping                 // GET http://localhost:8080/student
    public ResponseEntity<Collection<Student>> getAllStudent() {
        Collection<Student> students = service.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping(path = "/age")   // GET http://localhost:8080/student/age?age=15
    public ResponseEntity<Collection<Student>> getAllStudentByAge(@RequestParam Integer age) {
        Collection<Student> students = service.getAllStudentsByAge(age);
        return ResponseEntity.ok(students);
    }

    @PostMapping                // POST http://localhost:8080/student
    public Student addStudent(@RequestBody Student student) {
        return service.add(student);
    }

    @PutMapping                 // PUT http://localhost:8080/student/
    public ResponseEntity<Student> putStudent(@RequestBody Student student) {
        Student findStudent = service.edit(student);
        if (findStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(findStudent);
    }

    @DeleteMapping(path = "/{id}") // DELETE http://localhost:8080/student/7
    public Student deleteStudent(@PathVariable Long id) {
        return service.delete(id);
    }
}
