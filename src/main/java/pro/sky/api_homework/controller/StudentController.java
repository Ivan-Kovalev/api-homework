package pro.sky.api_homework.controller;

import org.springframework.http.HttpStatus;
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
        Student updated = service.edit(student);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.delete(id);
    }
}
