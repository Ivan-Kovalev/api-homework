//package pro.sky.api_homework.service;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import pro.sky.api_homework.model.Student;
//
//class StudentServiceTest {
//
//    private final StudentService service = new StudentService();
//    private final Student defaultStudent = new Student(1L, "123", 15);
//
//    @Test
//    void add() {
//        Assertions.assertEquals(defaultStudent, service.add(new Student(1L, "123", 15)));
//        Assertions.assertEquals(1, service.getAllStudents().size());
//        Assertions.assertNotNull(service.getAllStudents());
//    }
//
//    @Test
//    void find() {
//        service.add(defaultStudent);
//
//        Assertions.assertEquals(defaultStudent, service.find(1L));
//    }
//
//    @Test
//    void edit() {
//        service.add(defaultStudent);
//
//        Assertions.assertEquals(new Student(1L, "Рон", 10),
//                service.edit(new Student(1L, "Рон", 10)));
//
//        Assertions.assertEquals(defaultStudent,
//                service.edit(new Student(1L, "123", 15)));
//    }
//
//    @Test
//    void delete() {
//        service.add(defaultStudent);
//
//        Assertions.assertEquals(defaultStudent, service.delete(defaultStudent.getId()));
//        Assertions.assertTrue(service.getAllStudents().isEmpty());
//    }
//
//    @Test
//    void getAllStudents() {
//        service.add(defaultStudent);
//        service.add(defaultStudent);
//
//        Assertions.assertEquals(2, service.getAllStudents().size());
//    }
//
//    @Test
//    void getAllStudentsByAge() {
//        service.add(new Student(0L, "111", 15));
//        service.add(new Student(1L, "222", 16));
//        service.add(new Student(2L, "333", 15));
//
//        Assertions.assertEquals(2, service.getAllStudentsByAge(15).size());
//        Assertions.assertEquals(1, service.getAllStudentsByAge(16).size());
//    }
//}