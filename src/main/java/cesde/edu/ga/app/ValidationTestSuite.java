package cesde.edu.ga.app;

import cesde.edu.ga.model.*;
import cesde.edu.ga.repository.impl.*;
import cesde.edu.ga.service.impl.*;
import cesde.edu.ga.exceptions.*;

public class ValidationTestSuite {

    private static int testsRun = 0;
    private static int testsPassed = 0;

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("EJECUTANDO PRUEBAS DE VALIDACIÓN Y REGLAS DE NEGOCIO");
        System.out.println("=================================================");

        testStudentValidations();
        testTeacherValidations();
        testGroupValidations();
        testPeriodValidations();
        testProgramValidations();
        testSubjectValidations();
        testUserValidations();
        testEnrollmentValidations();
        testGradeValidations();
        testRepositoryInMemoryUpdateBug();

        System.out.println("=================================================");
        System.out.println("RESUMEN DE PRUEBAS:");
        System.out.println("Pruebas ejecutadas: " + testsRun);
        System.out.println("Pruebas exitosas:   " + testsPassed);
        System.out.println("Pruebas fallidas:   " + (testsRun - testsPassed));
        System.out.println("=================================================");

        if (testsRun != testsPassed) {
            System.exit(1);
        }
    }

    private static void assertThrows(Runnable r, Class<? extends Throwable> expectedException, String testName) {
        testsRun++;
        try {
            r.run();
            System.err.println("[FAIL] " + testName + " - Se esperaba la excepción: " + expectedException.getSimpleName());
        } catch (Throwable t) {
            if (expectedException.isInstance(t)) {
                testsPassed++;
                System.out.println("[PASS] " + testName);
            } else {
                System.err.println("[FAIL] " + testName + " - Se obtuvo " + t.getClass().getSimpleName() + " en lugar de " + expectedException.getSimpleName());
            }
        }
    }

    private static void assertDoesNotThrow(Runnable r, String testName) {
        testsRun++;
        try {
            r.run();
            testsPassed++;
            System.out.println("[PASS] " + testName);
        } catch (Throwable t) {
            System.err.println("[FAIL] " + testName + " - Excepción inesperada: " + t.getMessage());
            t.printStackTrace();
        }
    }

    private static void testStudentValidations() {
        StudentRepositoryInMemory repo = new StudentRepositoryInMemory();
        StudentServiceImpl service = new StudentServiceImpl(repo);

        // 1. Nombre obligatorio
        Student s1 = new Student(1L, "CC", "12345", "", "Pérez", "ACTIVE", "2010-05-15");
        assertThrows(() -> service.create(s1), StudentExceptions.class, "Student - Nombre vacío lanza excepción");

        // 2. Edad inválida (futura)
        Student s2 = new Student(2L, "CC", "12346", "Juan", "Pérez", "ACTIVE", "2030-05-15");
        assertThrows(() -> service.create(s2), StudentExceptions.class, "Student - Fecha de nacimiento en el futuro lanza excepción");

        // 3. Edad inválida (demasiado joven < 5 años)
        Student s3 = new Student(3L, "CC", "12347", "Juan", "Pérez", "ACTIVE", "2024-05-15");
        assertThrows(() -> service.create(s3), StudentExceptions.class, "Student - Estudiante menor de 5 años lanza excepción");

        // 4. Estudiante válido
        Student s4 = new Student(4L, "CC", "12348", "Juan", "Pérez", "ACTIVE", "2015-05-15");
        assertDoesNotThrow(() -> service.create(s4), "Student - Registro exitoso de estudiante válido");

        // 5. Documento duplicado
        Student s5 = new Student(5L, "CC", "12348", "María", "Gómez", "ACTIVE", "2012-05-15");
        assertThrows(() -> service.create(s5), StudentExceptions.class, "Student - Documento duplicado lanza excepción");
    }

    private static void testTeacherValidations() {
        TeacherRepositoryInMemory repo = new TeacherRepositoryInMemory();
        TeacherServiceImpl service = new TeacherServiceImpl(repo);

        // 1. Especialidad obligatoria
        Teacher t1 = new Teacher(1L, 1L, "CC", "98765", "Carlos", "Restrepo", "ACTIVE", "");
        assertThrows(() -> service.create(t1), TeacherExceptions.class, "Teacher - Especialidad vacía lanza excepción");

        // 2. Docente válido
        Teacher t2 = new Teacher(2L, 2L, "CC", "98765", "Carlos", "Restrepo", "ACTIVE", "Ingeniería de Software");
        assertDoesNotThrow(() -> service.create(t2), "Teacher - Registro exitoso de docente válido");

        // 3. Documento duplicado
        Teacher t3 = new Teacher(3L, 3L, "CC", "98765", "Marta", "Pineda", "ACTIVE", "Matemáticas");
        assertThrows(() -> service.create(t3), TeacherExceptions.class, "Teacher - Documento duplicado lanza excepción");
    }

    private static void testGroupValidations() {
        GroupRepositoryInMemory repo = new GroupRepositoryInMemory();
        GroupServiceImpl service = new GroupServiceImpl(repo);

        // 1. Nombre obligatorio (vacío)
        Group g1 = new Group(1L, "G-01", 1L, 1L, "Mañana", "", 30);
        assertThrows(() -> service.create(g1), GroupExceptions.class, "Group - Nombre vacío lanza excepción");

        // 2. Capacidad <= 0
        Group g2 = new Group(2L, "G-02", 1L, 1L, "Mañana", "Grupo A", 0);
        assertThrows(() -> service.create(g2), GroupExceptions.class, "Group - Capacidad cero lanza excepción");

        // 3. Grupo válido
        Group g3 = new Group(3L, "G-03", 1L, 1L, "Mañana", "Grupo B", 25);
        assertDoesNotThrow(() -> service.create(g3), "Group - Creación exitosa de grupo válido");
    }

    private static void testPeriodValidations() {
        PeriodRepositoryInMemory repo = new PeriodRepositoryInMemory();
        PeriodServiceImpl service = new PeriodServiceImpl(repo);

        // 1. Fecha de inicio no anterior a fecha de fin
        Period p1 = new Period(1L, "2026-1", "2026-06-30", "2026-06-01");
        assertThrows(() -> service.create(p1), PeriodExceptions.class, "Period - Fecha fin anterior a fecha inicio lanza excepción");

        // 2. Período válido
        Period p2 = new Period(2L, "2026-2", "2026-06-01", "2026-11-30");
        assertDoesNotThrow(() -> service.create(p2), "Period - Registro exitoso de período válido");
    }

    private static void testProgramValidations() {
        ProgramRepositoryInMemory repo = new ProgramRepositoryInMemory();
        ProgramServiceImpl service = new ProgramServiceImpl(repo);

        // 1. Nombre obligatorio
        Program pr1 = new Program(1L, "PR-01", "");
        assertThrows(() -> service.create(pr1), ProgramExceptions.class, "Program - Nombre vacío lanza excepción");

        // 2. Programa válido
        Program pr2 = new Program(2L, "PR-02", "Desarrollo de Software");
        assertDoesNotThrow(() -> service.create(pr2), "Program - Creación exitosa de programa válido");
    }

    private static void testSubjectValidations() {
        SubjectRepositoryInMemory repo = new SubjectRepositoryInMemory();
        SubjectServiceImpl service = new SubjectServiceImpl(repo);

        // 1. Nombre obligatorio
        Subject sb1 = new Subject(1L, "SUB-01", "", 4, 1L);
        assertThrows(() -> service.create(sb1), SubjectExceptions.class, "Subject - Nombre vacío lanza excepción");

        // 2. Asignatura válida
        Subject sb2 = new Subject(2L, "SUB-01", "Backend I", 4, 1L);
        assertDoesNotThrow(() -> service.create(sb2), "Subject - Creación exitosa de asignatura válida");

        // 3. Código único
        Subject sb3 = new Subject(3L, "SUB-01", "Frontend I", 3, 1L);
        assertThrows(() -> service.create(sb3), SubjectExceptions.class, "Subject - Código duplicado lanza excepción");
    }

    private static void testUserValidations() {
        UserRepositoryInMemory repo = new UserRepositoryInMemory();
        UserServiceImpl service = new UserServiceImpl(repo);

        // 1. Nombre de usuario obligatorio
        User u1 = new User(1L, "", "user@mail.com", "12345", "ACTIVE", "2026-06-01");
        assertThrows(() -> service.create(u1), UserExceptions.class, "User - Username vacío lanza excepción");

        // 2. Contraseña obligatoria/válida
        User u2 = new User(2L, "usuario1", "user@mail.com", "", "ACTIVE", "2026-06-01");
        assertThrows(() -> service.create(u2), UserExceptions.class, "User - Password vacía lanza excepción");

        // 3. Usuario válido
        User u3 = new User(3L, "usuario1", "user1@mail.com", "12345", "ACTIVE", "2026-06-01");
        assertDoesNotThrow(() -> service.create(u3), "User - Creación exitosa de usuario válido");

        // 4. Nombre de usuario duplicado
        User u4 = new User(4L, "usuario1", "user2@mail.com", "12345", "ACTIVE", "2026-06-01");
        assertThrows(() -> service.create(u4), UserExceptions.class, "User - Username duplicado lanza excepción");
    }

    private static void testEnrollmentValidations() {
        EnrollmentRepositoryInMemory enrollmentRepo = new EnrollmentRepositoryInMemory();
        StudentRepositoryInMemory studentRepo = new StudentRepositoryInMemory();
        GroupRepositoryInMemory groupRepo = new GroupRepositoryInMemory();
        EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl(enrollmentRepo, studentRepo, groupRepo);

        // Crear entidades base en repositorios
        Student student = studentRepo.create(new Student(1L, "CC", "1010", "Estudiante", "Uno", "ACTIVE", "2010-01-01"));
        Group group = groupRepo.create(new Group(1L, "G01", 1L, 1L, "Mañana", "Grupo 1", 2)); // Capacidad: 2

        // 1. Estudiante no existe
        Enrollment e1 = new Enrollment(1L, 999L, group.getGroupId(), 1L, "ACTIVE", "2026-06-01");
        assertThrows(() -> enrollmentService.create(e1), EnrollmentExceptions.class, "Enrollment - Estudiante no existe lanza excepción");

        // 2. Grupo no existe
        Enrollment e2 = new Enrollment(2L, student.getStudentId(), 999L, 1L, "ACTIVE", "2026-06-01");
        assertThrows(() -> enrollmentService.create(e2), EnrollmentExceptions.class, "Enrollment - Grupo no existe lanza excepción");

        // 3. Matrícula válida 1
        Enrollment e3 = new Enrollment(null, student.getStudentId(), group.getGroupId(), 1L, "ACTIVE", "2026-06-01");
        assertDoesNotThrow(() -> enrollmentService.create(e3), "Enrollment - Creación de primera matrícula");

        // 4. Matrícula duplicada en el mismo grupo
        Enrollment e4 = new Enrollment(null, student.getStudentId(), group.getGroupId(), 1L, "ACTIVE", "2026-06-01");
        assertThrows(() -> enrollmentService.create(e4), EnrollmentExceptions.class, "Enrollment - Matrícula duplicada en el mismo grupo lanza excepción");

        // Crear otro estudiante para probar cupos
        Student student2 = studentRepo.create(new Student(2L, "CC", "2020", "Estudiante", "Dos", "ACTIVE", "2010-01-01"));
        Enrollment e5 = new Enrollment(null, student2.getStudentId(), group.getGroupId(), 1L, "ACTIVE", "2026-06-01");
        assertDoesNotThrow(() -> enrollmentService.create(e5), "Enrollment - Creación de segunda matrícula (cupo 2/2)");

        // 5. No hay cupos disponibles
        Student student3 = studentRepo.create(new Student(3L, "CC", "3030", "Estudiante", "Tres", "ACTIVE", "2010-01-01"));
        Enrollment e6 = new Enrollment(null, student3.getStudentId(), group.getGroupId(), 1L, "ACTIVE", "2026-06-01");
        assertThrows(() -> enrollmentService.create(e6), EnrollmentExceptions.class, "Enrollment - Sin cupos disponibles lanza excepción");
    }

    private static void testGradeValidations() {
        GradeRepositoryInMemory gradeRepo = new GradeRepositoryInMemory();
        EnrollmentRepositoryInMemory enrollmentRepo = new EnrollmentRepositoryInMemory();
        GradeServiceImpl gradeService = new GradeServiceImpl(gradeRepo, enrollmentRepo);

        // Crear matrícula en el repositorio
        Enrollment enrollment = enrollmentRepo.create(new Enrollment(1L, 1L, 1L, 1L, "ACTIVE", "2026-06-01"));

        // 1. Estudiante no matriculado (matrícula no existente)
        Grade gr1 = new Grade(1L, 999L, 1L, 4.5, "Buena nota");
        assertThrows(() -> gradeService.create(gr1), GradeExceptions.class, "Grade - Matrícula no existente lanza excepción");

        // 2. Nota inválida (< 0)
        Grade gr2 = new Grade(2L, enrollment.getEnrollmentId(), 1L, -0.5, "Nota negativa");
        assertThrows(() -> gradeService.create(gr2), GradeExceptions.class, "Grade - Nota menor a 0.0 lanza excepción");

        // 3. Nota inválida (> 5)
        Grade gr3 = new Grade(3L, enrollment.getEnrollmentId(), 1L, 5.1, "Nota mayor a 5");
        assertThrows(() -> gradeService.create(gr3), GradeExceptions.class, "Grade - Nota mayor a 5.0 lanza excepción");

        // 4. Calificación válida
        Grade gr4 = new Grade(4L, enrollment.getEnrollmentId(), 1L, 4.8, "Nota excelente");
        assertDoesNotThrow(() -> gradeService.create(gr4), "Grade - Registro exitoso de nota válida");
    }

    private static void testRepositoryInMemoryUpdateBug() {
        // Probaremos que ahora la actualización con el mismo identificador único NO arroja error ni falso.
        StudentRepositoryInMemory studentRepo = new StudentRepositoryInMemory();
        Student student = studentRepo.create(new Student(1L, "CC", "5050", "Pedro", "Gómez", "ACTIVE", "2000-01-01"));

        student.setFirstName("Pedro Modificado");
        testsRun++;
        boolean updated = studentRepo.update(student);
        if (updated && studentRepo.findById(student.getStudentId()).getFirstName().equals("Pedro Modificado")) {
            testsPassed++;
            System.out.println("[PASS] Repository InMemory Update - Actualización con el mismo documento funciona correctamente");
        } else {
            System.err.println("[FAIL] Repository InMemory Update - La actualización falló debido a conflicto de documento de sí mismo");
        }
    }
}
