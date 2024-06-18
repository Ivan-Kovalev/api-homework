package pro.sky.api_homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.api_homework.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
