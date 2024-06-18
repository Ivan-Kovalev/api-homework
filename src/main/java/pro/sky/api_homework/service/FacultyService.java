package pro.sky.api_homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.api_homework.model.Faculty;
import pro.sky.api_homework.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FacultyService {

    @Autowired
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty find(Long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty edit(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void delete(Long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getAllFacultyByColor(String color) {
        Collection<Faculty> facultiesByColor = new ArrayList<>();
        for (Faculty faculty : facultyRepository.findAll()) {
            if (faculty.getColor().equals(color)) {
                facultiesByColor.add(faculty);
            }
        }
        return facultiesByColor;
    }
}
