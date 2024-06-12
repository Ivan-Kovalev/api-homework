package pro.sky.api_homework.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.api_homework.model.Faculty;

class FacultyServiceTest {

    private final FacultyService service = new FacultyService();
    private final Faculty defaultFaculty = new Faculty(1L, "123", "123");

    @Test
    void add() {
        Assertions.assertEquals(defaultFaculty, service.add(new Faculty(1L, "123", "123")));
        Assertions.assertEquals(1, service.getAllFaculty().size());
        Assertions.assertNotNull(service.getAllFaculty());
    }

    @Test
    void find() {
        service.add(defaultFaculty);

        Assertions.assertEquals(defaultFaculty, service.find(1L));
    }

    @Test
    void edit() {
        service.add(defaultFaculty);

        Assertions.assertEquals(new Faculty(1L, "666", "000"),
                service.edit(new Faculty(1L, "666", "000")));

        Assertions.assertEquals(defaultFaculty,
                service.edit(new Faculty(1L, "123", "123")));

    }

    @Test
    void delete() {
        service.add(defaultFaculty);

        Assertions.assertEquals(defaultFaculty, service.delete(defaultFaculty.getId()));
        Assertions.assertTrue(service.getAllFaculty().isEmpty());
    }

    @Test
    void getAllFaculty() {
        service.add(defaultFaculty);
        service.add(defaultFaculty);

        Assertions.assertEquals(2, service.getAllFaculty().size());
    }

    @Test
    void getAllFacultyByColor() {
        service.add(new Faculty(0L, "111", "красный"));
        service.add(new Faculty(1L, "222", "синий"));
        service.add(new Faculty(2L, "333", "красный"));

        Assertions.assertEquals(2, service.getAllFacultyByColor("красный").size());
        Assertions.assertEquals(1, service.getAllFacultyByColor("синий").size());
    }
}