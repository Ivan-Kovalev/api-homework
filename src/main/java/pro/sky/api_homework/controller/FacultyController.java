package pro.sky.api_homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.api_homework.model.Faculty;
import pro.sky.api_homework.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping(path = "faculty")
public class FacultyController {

    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}") // GET http://localhost:8080/faculty/2
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty faculty = service.find(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @GetMapping                 // GET http://localhost:8080/faculty
    public ResponseEntity<Collection<Faculty>> getAllFaculty() {
        Collection<Faculty> faculty = service.getAllFaculty();
        return ResponseEntity.ok(faculty);
    }

    @GetMapping(path = "/color")   // GET http://localhost:8080/faculty/color?color=orange
    public ResponseEntity<Collection<Faculty>> getAllFacultyByColor(@RequestParam String color) {
        Collection<Faculty> faculty = service.getAllFacultyByColor(color);
        return ResponseEntity.ok(faculty);
    }

    @PostMapping                // POST http://localhost:8080/faculty
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return service.add(faculty);
    }

    @PutMapping                 // PUT http://localhost:8080/faculty
    public ResponseEntity<Faculty> putFaculty(@RequestBody Faculty faculty) {
        Faculty findFaculty = service.edit(faculty);
        if (findFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(findFaculty);
    }

    @DeleteMapping(path = "/{id}") // DELETE http://localhost:8080/faculty/2
    public Faculty deleteFaculty(@PathVariable Long id) {
        return service.delete(id);
    }

}
