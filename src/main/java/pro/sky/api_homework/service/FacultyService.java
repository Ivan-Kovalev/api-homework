package pro.sky.api_homework.service;

import org.springframework.stereotype.Service;
import pro.sky.api_homework.model.Faculty;
import pro.sky.api_homework.model.Student;
import pro.sky.api_homework.repository.FacultyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty find(Long id) {
        return facultyRepository.findById(id)
                .orElse(null);
    }

    public Faculty edit(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public boolean delete(Long id) {
        Optional<Faculty> facultyOptional = facultyRepository.findById(id);
        if (facultyOptional.isPresent()) {
            facultyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public List<Faculty> getAllFacultyByColor(String color) {
        return facultyRepository.findFacultyByColor(color);
    }
}
