package pro.sky.api_homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.api_homework.model.Student;

public interface FacultyRepository extends JpaRepository<Student, Long> {
}
