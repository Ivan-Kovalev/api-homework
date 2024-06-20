package pro.sky.api_homework.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.api_homework.model.Faculty;
import pro.sky.api_homework.repository.FacultyRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class FacultyServiceTest {

    private final Faculty faculty = new Faculty(1L, "Gryffindor", "red");
    private final List<Faculty> faculties = List.of(
            new Faculty(1L, "Gryffindor", "red"),
            new Faculty(2L, "Slytherin", "green"),
            new Faculty(3L, "GryffindorCopy", "red"),
            new Faculty(4L, "SlytherinCopy", "green"),
            new Faculty(5L, "SlytherinCopy2", null));

    @Mock
    private FacultyRepository facultyRepository;

    @InjectMocks
    private FacultyService service;

    @Test
    void add() {
        Mockito.when(facultyRepository.save(any())).thenReturn(faculty);

        Assertions.assertEquals(faculty, service.add(new Faculty(1L, "Gryffindor", "red")));
    }

    @Test
    void find() {
        Mockito.when(facultyRepository.findById(1L)).thenReturn(Optional.of(faculty));

        Assertions.assertEquals(faculty, service.find(1L));
    }

    @Test
    void edit() {
        Mockito.when(facultyRepository.save(new Faculty(1L, "Gryffindor", "red"))).thenReturn(faculty);

        Assertions.assertEquals(faculty, service.edit(new Faculty(1L, "Gryffindor", "red")));
    }

    @Test
    void delete() {
//        Long id = 1L;
//        service.delete(id);
//        Mockito.verify(facultyRepository, Mockito.timeout(1)).deleteById(id);
    }

    @Test
    void getAllFaculty() {
        Mockito.when(facultyRepository.findAll()).thenReturn(faculties);

        Assertions.assertEquals(faculties, service.getAllFaculty());
        Assertions.assertEquals(5, service.getAllFaculty().size());
    }

    @Test
    void getAllFacultyByColor() {
    }
}