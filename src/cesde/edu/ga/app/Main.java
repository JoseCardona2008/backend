package cesde.edu.ga.app;

import cesde.edu.ga.model.*;
import cesde.edu.ga.model.Enrollment;
import cesde.edu.ga.model.Grade;
import cesde.edu.ga.model.Group;
import cesde.edu.ga.model.GroupSubject;
import cesde.edu.ga.model.Period;
import cesde.edu.ga.model.Program;
import co.edu.cesde.ga.model.Role;
import co.edu.cesde.ga.model.Student;
import co.edu.cesde.ga.model.Subject;
import co.edu.cesde.ga.model.Teacher;
import co.edu.cesde.ga.model.User;
import cesde.edu.ga.model.UserRole;

public class Main {

    public static void main(String[] args) {

        // Enrollment
        Enrollment enrollment = new Enrollment();

        enrollment.setEnrollmentId(1L);
        enrollment.setStudentId(1L);
        enrollment.setGroupId(1L);
        enrollment.setPeriodId(1L);
        enrollment.setStatus("ACTIVE");
        enrollment.setCreatedAt("2026-02-20");

        System.out.println("Enrollment ID: " + enrollment.getEnrollmentId());
        System.out.println("Student ID: " + enrollment.getStudentId());
        System.out.println("Group ID: " + enrollment.getGroupId());
        System.out.println("Period ID: " + enrollment.getPeriodId());
        System.out.println("Status: " + enrollment.getStatus());
        System.out.println("Created At: " + enrollment.getCreatedAt());

        Enrollment enrollment2 = new Enrollment(2L, 2L, 2L, 2L, "INACTIVE", "2026-02-01");

        System.out.println("Enrollment ID: " + enrollment2.getEnrollmentId());
        System.out.println("Student ID: " + enrollment2.getStudentId());
        System.out.println("Group ID: " + enrollment2.getGroupId());
        System.out.println("Period ID: " + enrollment2.getPeriodId());
        System.out.println("Status: " + enrollment2.getStatus());
        System.out.println("Created At: " + enrollment2.getCreatedAt());


        // Grade
        Grade grade = new Grade();

        grade.setGradeId(1L);
        grade.setEnrollmentId(1L);
        grade.setGroupSubjectId(1L);
        grade.setFinalScore(4.7);
        grade.setObservations("Excellent");

        System.out.println("Grade ID: " + grade.getGradeId());
        System.out.println("Enrollment ID: " + grade.getEnrollmentId());
        System.out.println("GroupSubject ID: " + grade.getGroupSubjectId());
        System.out.println("Final Score: " + grade.getFinalScore());
        System.out.println("Observations: " + grade.getObservations());

        Grade grade2 = new Grade(2L, 2L, 2L, 3.8, "Good");

        System.out.println("Grade ID: " + grade2.getGradeId());
        System.out.println("Enrollment ID: " + grade2.getEnrollmentId());
        System.out.println("GroupSubject ID: " + grade2.getGroupSubjectId());
        System.out.println("Final Score: " + grade2.getFinalScore());
        System.out.println("Observations: " + grade2.getObservations());


        // Group
        Group group = new Group();

        group.setGroupId(1L);
        group.setCode("G1");
        group.setProgramId(1L);
        group.setPeriodId(1L);
        group.setSchedule("Morning");

        System.out.println("Group ID: " + group.getGroupId());
        System.out.println("Code: " + group.getCode());
        System.out.println("Program ID: " + group.getProgramId());
        System.out.println("Period ID: " + group.getPeriodId());
        System.out.println("Schedule: " + group.getSchedule());

        Group group2 = new Group(2L, "G2", 2L, 2L, "Night");

        System.out.println("Group ID: " + group2.getGroupId());
        System.out.println("Code: " + group2.getCode());
        System.out.println("Program ID: " + group2.getProgramId());
        System.out.println("Period ID: " + group2.getPeriodId());
        System.out.println("Schedule: " + group2.getSchedule());


        // GroupSubject
        GroupSubject groupSubject = new GroupSubject();

        groupSubject.setGroupSubjectId(1L);
        groupSubject.setGroupId(1L);
        groupSubject.setSubjectId(1L);
        groupSubject.setTeacherId(1L);

        System.out.println("GroupSubject ID: " + groupSubject.getGroupSubjectId());
        System.out.println("Group ID: " + groupSubject.getGroupId());
        System.out.println("Subject ID: " + groupSubject.getSubjectId());
        System.out.println("Teacher ID: " + groupSubject.getTeacherId());

        GroupSubject groupSubject2 = new GroupSubject(2L, 2L, 2L, 2L);

        System.out.println("GroupSubject ID: " + groupSubject2.getGroupSubjectId());
        System.out.println("Group ID: " + groupSubject2.getGroupId());
        System.out.println("Subject ID: " + groupSubject2.getSubjectId());
        System.out.println("Teacher ID: " + groupSubject2.getTeacherId());


        // Period
        Period period = new Period();

        period.setPeriodId(1L);
        period.setCode("2026-1");
        period.setStartDate("2026-02-28");
        period.setEndDate("2026-03-15");

        System.out.println("Period ID: " + period.getPeriodId());
        System.out.println("Code: " + period.getCode());
        System.out.println("Start Date: " + period.getStartDate());
        System.out.println("End Date: " + period.getEndDate());

        Period period2 = new Period(2L, "2026-2", "2026-07-01", "2026-12-01");

        System.out.println("Period ID: " + period2.getPeriodId());
        System.out.println("Code: " + period2.getCode());
        System.out.println("Start Date: " + period2.getStartDate());
        System.out.println("End Date: " + period2.getEndDate());


        // Program
        Program program = new Program();

        program.setProgramId(1L);
        program.setCode("www");
        program.setName("Desarrollo de software");

        System.out.println("Program ID: " + program.getProgramId());
        System.out.println("Code: " + program.getCode());
        System.out.println("Name: " + program.getName());

        Program program2 = new Program(2L, "web", "Diseño grafico");

        System.out.println("Program ID: " + program2.getProgramId());
        System.out.println("Code: " + program2.getCode());
        System.out.println("Name: " + program2.getName());


        // Role
        Role role = new Role();

        role.setRoleId(1L);
        role.setName("ADMIN");
        role.setDescription("Administrator");

        System.out.println("Role ID: " + role.getRoleId());
        System.out.println("Name: " + role.getName());
        System.out.println("Description: " + role.getDescription());

        Role role2 = new Role(2L, "STUDENT", "student");

        System.out.println("Role ID: " + role2.getRoleId());
        System.out.println("Name: " + role2.getName());
        System.out.println("Description: " + role2.getDescription());


        // Student
        Student student = new Student();

        student.setUserId(5L);
        student.setCode("12345");
        student.setDocumentNumber("104050678");
        student.setFirstName("Santi");
        student.setLastName("Calde");
        student.setStatus("ACTIVE");
        student.setBirthDate("2006-04-04");

        System.out.println("User ID: " + student.getUserId());
        System.out.println("Code: " + student.getCode());
        System.out.println("Document Number: " + student.getDocumentNumber());
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("Status: " + student.getStatus());
        System.out.println("Birth Date: " + student.getBirthDate());

        Student student2 = new Student(6L, "123456", "103689038", "Juan", "David", "INACTIVE", "1999-12-31");

        System.out.println("User ID: " + student2.getUserId());
        System.out.println("Code: " + student2.getCode());
        System.out.println("Document Number: " + student2.getDocumentNumber());
        System.out.println("First Name: " + student2.getFirstName());
        System.out.println("Last Name: " + student2.getLastName());
        System.out.println("Status: " + student2.getStatus());
        System.out.println("Birth Date: " + student2.getBirthDate());


        // Subject
        Subject subject = new Subject();

        subject.setSubjectId(1L);
        subject.setCode("BACK");
        subject.setName("backend I");
        subject.setCredits(4);
        subject.setProgramId(1L);

        System.out.println("Subject ID: " + subject.getSubjectId());
        System.out.println("Code: " + subject.getCode());
        System.out.println("Name: " + subject.getName());
        System.out.println("Credits: " + subject.getCredits());
        System.out.println("Program ID: " + subject.getProgramId());

        Subject subject2 = new Subject(2L, "Front", "Fronted", 3, 1L);

        System.out.println("Subject ID: " + subject2.getSubjectId());
        System.out.println("Code: " + subject2.getCode());
        System.out.println("Name: " + subject2.getName());
        System.out.println("Credits: " + subject2.getCredits());
        System.out.println("Program ID: " + subject2.getProgramId());


        // Teacher
        Teacher teacher = new Teacher();

        teacher.setUserId(3L);
        teacher.setCode("789012");
        teacher.setDocumentNumber("1122334455");
        teacher.setFirstName("Alice");
        teacher.setLastName("Johnson");
        teacher.setStatus("ACTIVE");

        System.out.println("User ID: " + teacher.getUserId());
        System.out.println("Code: " + teacher.getCode());
        System.out.println("Document Number: " + teacher.getDocumentNumber());
        System.out.println("First Name: " + teacher.getFirstName());
        System.out.println("Last Name: " + teacher.getLastName());
        System.out.println("Status: " + teacher.getStatus());

        Teacher teacher2 = new Teacher(4L, "123456", "1040237382", "Luis", "Goenaga", "ACTIVE");

        System.out.println("User ID: " + teacher2.getUserId());
        System.out.println("Code: " + teacher2.getCode());
        System.out.println("Document Number: " + teacher2.getDocumentNumber());
        System.out.println("First Name: " + teacher2.getFirstName());
        System.out.println("Last Name: " + teacher2.getLastName());
        System.out.println("Status: " + teacher2.getStatus());


        // User
        User user = new User();

        user.setUserId(1L);
        user.setUsername("joc08");
        user.setEmail("jose@mail.com");
        user.setPasswordHash("12345");
        user.setStatus("ACTIVE");
        user.setCreatedAt("2026-02-29");

        System.out.println("User ID: " + user.getUserId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password Hash: " + user.getPasswordHash());
        System.out.println("Status: " + user.getStatus());
        System.out.println("Created At: " + user.getCreatedAt());

        User user2 = new User(2L, "juan", "juan@mail.com", "juan09", "INACTIVE", "2026-03-01");

        System.out.println("User ID: " + user2.getUserId());
        System.out.println("Username: " + user2.getUsername());
        System.out.println("Email: " + user2.getEmail());
        System.out.println("Password Hash: " + user2.getPasswordHash());
        System.out.println("Status: " + user2.getStatus());
        System.out.println("Created At: " + user2.getCreatedAt());


        // UserRole
        UserRole userRole = new UserRole();

        userRole.setUserRoleId(1L);
        userRole.setUserId(1L);
        userRole.setRoleId(1L);

        System.out.println("UserRole ID: " + userRole.getUserRoleId());
        System.out.println("User ID: " + userRole.getUserId());
        System.out.println("Role ID: " + userRole.getRoleId());

        UserRole userRole2 = new UserRole(2L, 2L, 2L);

        System.out.println("UserRole ID: " + userRole2.getUserRoleId());
        System.out.println("User ID: " + userRole2.getUserId());
        System.out.println("Role ID: " + userRole2.getRoleId());

    }
}