package pro.sky.api_homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.api_homework.model.Student;
import pro.sky.api_homework.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public Student find(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("не смог найти студента по айди = " + id));
    }

    public Student edit(Student student) {
        return studentRepository.save(student);
    }

    public boolean delete(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getAllStudentsByAge(Integer age) {
        return studentRepository.findAll().stream()
                .filter(faculty -> faculty.getAge().equals(age))
                .toList();
    }
}
