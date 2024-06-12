package pro.sky.api_homework.service;

import org.springframework.stereotype.Service;
import pro.sky.api_homework.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long id = 0L;

    public Student add(Student student) {
        student.setId(++id);
        students.put(id, student);
        return student;
    }

    public Student find(Long id) {
        return students.get(id);
    }

    public Student edit(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student delete(Long id) {
        return students.remove(id);
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public Collection<Student> getAllStudentsByAge(Integer age) {
        Collection<Student> studentsByAge = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge().equals(age)) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }
}
