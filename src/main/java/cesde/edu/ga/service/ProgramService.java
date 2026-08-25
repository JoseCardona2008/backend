package cesde.edu.ga.service;

import cesde.edu.ga.model.Program;
import java.util.List;

public interface ProgramService {
    Program create(Program program);

    boolean update(Program program);

    boolean delete(Long programId);

    Program findById(Long programId);

    List<Program> findAll();
}
