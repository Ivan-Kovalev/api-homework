package pro.sky.api_homework.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.api_homework.model.Student;
import pro.sky.api_homework.repository.StudentRepository;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    private final Student student = new Student(1L, "Harry Potter", 16);
    private final List<Student> students = List.of(
            new Student(1L, "Harry Potter", 16),
            new Student(2L, "Ron Weasley", 16),
            new Student(3L, "Hermione Granger", 15));

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService service;

    @Test
    void add() {
        Mockito.when(studentRepository.save(new Student(1L, "Harry Potter", 16))).thenReturn(student);

        Assertions.assertEquals(student, service.add(new Student(1L, "Harry Potter", 16)));
    }

    @Test
    void find() {
        Mockito.when(studentRepository.findById(1L).get()).thenReturn(student);

        Assertions.assertEquals(student, service.find(1L));
    }

    @Test
    void edit() {
        Mockito.when(studentRepository.save(new Student(1L, "Harry Potter", 16))).thenReturn(student);

        Assertions.assertEquals(student, service.edit(new Student(1L, "Harry Potter", 16)));
    }

    @Test
    void delete() {
    }

    @Test
    void getAllStudents() {
        Mockito.when(studentRepository.findAll()).thenReturn(students);

        Assertions.assertEquals(students, service.getAllStudents());
        Assertions.assertEquals(3, service.getAllStudents().size());
    }

    @Test
    void getAllStudentsByAge() {
        Mockito.when(studentRepository.findAll()).thenReturn(students);

        Assertions.assertEquals(2, service.getAllStudentsByAge(16).size());
        Assertions.assertEquals(1, service.getAllStudentsByAge(15).size());
    }
}