package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.Teacher;
import cesde.edu.ga.repository.TeacherRepository;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryInMemory implements TeacherRepository {

    private List<Teacher> teachers;
    private Long nextTeacherId;

    public TeacherRepositoryInMemory(){
        this.teachers = new ArrayList<>();
        this.nextTeacherId = 1L;
    }

    @Override
    public Teacher create(Teacher teacher){

        if (teacher == null){
            return null;
        }

        if (existsByDocumentNumber(teacher.getDocumentNumber())){
            return null;
        }

        teacher.setTeacherId(nextTeacherId++);
        teachers.add(teacher);
        return teacher;
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {

        if  (documentNumber == null || documentNumber.isEmpty()){
            return false;
        }

        return findByDocumentNumber(documentNumber) != null;
    }

    @Override
    public Teacher findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()){
            return null;
        }

        for (Teacher teacher : teachers) {
            if (documentNumber.equals(teacher.getDocumentNumber())) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return new ArrayList<>(teachers);
    }

    @Override
    public Teacher findById(Long teacherId) {
        if (teacherId ==  null || teacherId <= 0){
            return null;
        }
        for (Teacher teacher : teachers) {
            if (teacherId.equals(teacher.getTeacherId())) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long teacherId) {

        Teacher teacher = findById(teacherId);
        if  (teacher == null) return false;
        teachers.remove(teacher);
        return true;
    }

    @Override
    public int count() {
        return teachers.size();
    }

    @Override
    public boolean update(Teacher updatedTeacher) {
        if (updatedTeacher == null) return false;
        if (findByDocumentNumber(updatedTeacher.getDocumentNumber()) != null){
            return false;
        }

        for (int i=0; i<teachers.size(); i++) {

            if (updatedTeacher.getTeacherId().equals(teachers.get(i).getTeacherId())) {
                teachers.set(i, updatedTeacher);
                return true;
            }
        }
        return false;
    }
}
