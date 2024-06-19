package pro.sky.api_homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.api_homework.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
