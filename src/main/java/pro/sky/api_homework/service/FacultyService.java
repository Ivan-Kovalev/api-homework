package pro.sky.api_homework.service;

import org.springframework.stereotype.Service;
import pro.sky.api_homework.model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private Long id = 0L;

    public Faculty add(Faculty faculty) {
        faculty.setId(++id);
        faculties.put(id, faculty);
        return faculty;
    }

    public Faculty find(Long id) {
        return faculties.get(id);
    }

    public Faculty edit(Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty delete(Long id) {
        return faculties.remove(id);
    }

    public Collection<Faculty> getAllFaculty() {
        return faculties.values();
    }

    public Collection<Faculty> getAllFacultyByColor(String color) {
        Collection<Faculty> facultiesByColor = new ArrayList<>();
        for (Faculty faculty : faculties.values()) {
            if (faculty.getColor().equals(color)) {
                facultiesByColor.add(faculty);
            }
        }
        return facultiesByColor;
    }
}
