package pro.sky.api_homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.api_homework.model.Student;
import pro.sky.api_homework.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public Student find(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student edit(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Collection<Student> getAllStudentsByAge(Integer age) {
        Collection<Student> studentsByAge = new ArrayList<>();
        for (Student student : studentRepository.findAll()) {
            if (student.getAge().equals(age)) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }
}
