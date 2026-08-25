package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.Program;
import cesde.edu.ga.repository.ProgramRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProgramRepositoryInMemory implements ProgramRepository {
    private List<Program> programs;
    private Long nextProgramId;
    public ProgramRepositoryInMemory() {
        this.programs = new ArrayList<>();
        this.nextProgramId = 1L;
    }
    @Override
    public Program create(Program program) {
        if (program == null) return null;
        if (existsByCode(program.getCode())) return null;
        program.setProgramId(nextProgramId++);
        programs.add(program);
        return program;
    }
    @Override
    public boolean existsByCode(String code) {
        if (code == null || code.isBlank()) return false;
        return findByCode(code) != null;
    }
    @Override
    public Program findByCode(String code) {
        if (code == null || code.isBlank()) return null;
        for (Program program : programs) {
            if (code.equals(program.getCode())) {
                return program;
            }
        }
        return null;
    }
    @Override
    public List<Program> findAll() {
        return new ArrayList<>(programs);
    }
    @Override
    public Program findById(Long programId) {
        if (programId == null || programId <= 0) return null;
        for (Program program : programs) {
            if (programId.equals(program.getProgramId())) {
                return program;
            }
        }
        return null;
    }
    @Override
    public boolean delete(Long programId) {
        Program program = findById(programId);
        if (program == null) return false;
        programs.remove(program);
        return true;
    }
    @Override
    public int count() {
        return programs.size();
    }
    @Override
    public boolean update(Program updatedProgram) {
        if (updatedProgram == null) return false;
        for (int i = 0; i < programs.size(); i++) {
            if (updatedProgram.getProgramId().equals(programs.get(i).getProgramId())) {
                programs.set(i, updatedProgram);
                return true;
            }
        }
        return false;
    }
    
}
