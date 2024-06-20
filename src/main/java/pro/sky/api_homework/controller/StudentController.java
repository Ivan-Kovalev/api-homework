package pro.sky.api_homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.api_homework.model.Student;
import pro.sky.api_homework.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = service.find(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudent() {
        Collection<Student> students = service.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping(path = "/{age}")
    public Collection<Student> getAllStudentByAge(@PathVariable Integer age) {
        return service.getAllStudentsByAge(age);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.add(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student findStudent = service.edit(student);
        return ResponseEntity.ok(findStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        boolean isDeleted = service.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
