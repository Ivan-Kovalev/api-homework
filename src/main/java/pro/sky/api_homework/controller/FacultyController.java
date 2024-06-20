package pro.sky.api_homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.api_homework.model.Faculty;
import pro.sky.api_homework.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping(path = "faculties")
public class FacultyController {

    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty faculty = service.find(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFaculty() {
        Collection<Faculty> faculty = service.getAllFaculty();
        return ResponseEntity.ok(faculty);
    }

    @GetMapping(path = "/{color}")
    public ResponseEntity<Collection<Faculty>> getAllFacultyByColor(@PathVariable String color) {
        Collection<Faculty> faculty = service.getAllFacultyByColor(color);
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return service.add(faculty);
    }

    @PutMapping public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty updatedFaculty) {
        Faculty updated = service.edit(updatedFaculty);
        if(updated!=null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        boolean isDeleted = service.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
