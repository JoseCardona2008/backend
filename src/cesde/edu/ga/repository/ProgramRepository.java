package cesde.edu.ga.repository;

import cesde.edu.ga.model.Program;
import java.util.List;

public interface ProgramRepository {

    Program create(Program program);

    Program findById(Long programId);

    Program findByCode(String code);

    List<Program> findAll();

    boolean update(Program program);

    boolean delete(Long programId);

    boolean existsByCode(String code);

    int count();
}