package cesde.edu.ga.app;

import cesde.edu.ga.model.Student;
import cesde.edu.ga.repository.StudentRepository;
import cesde.edu.ga.repository.impl.StudentRepositoryInMemory;
import cesde.edu.ga.repository.service.StudentService;
import cesde.edu.ga.repository.service.impl.StudentServiceImpl;

public class AppMain {
    public  static  void main(String []args) {

        StudentRepository studentRepository = new StudentRepositoryInMemory();
        StudentService studentService = new StudentServiceImpl(studentRepository);

        Student student = new Student(null, null, "S001", "123456789", "Jhon", "Perez", "Activo", "20-10-2007");
        studentService.create(student);
        System.out.println("Estudiante creado con exito");

        Student student2 = new Student(null, null, "S002", "987654321", "Maria", "Gomez", "Activo", "15-05-2006");
        studentService.create(student2);
        System.out.println("Segundo estudiante creado con exito");

        studentService.findAll().forEach(System.out::println);
    }
}
