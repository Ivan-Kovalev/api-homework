package pro.sky.api_homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.api_homework.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
