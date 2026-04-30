package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Program;
import cesde.edu.ga.repository.ProgramRepository;
import cesde.edu.ga.service.ProgramService;

import java.util.List;

public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program create(Program program) {
        if (isInvalidProgram(program)) {
            return null;
        }
        return programRepository.create(program);
    }

    @Override
    public boolean update(Program program) {
        if (isInvalidProgram(program)
                || program.getProgramId() == null
                || program.getProgramId() <= 0L) {
            return false;
        }
        return programRepository.update(program);
    }

    @Override
    public boolean delete(Long programId) {
        if (programId == null || programId <= 0L) {
            return false;
        }
        return programRepository.delete(programId);
    }

    @Override
    public Program findById(Long programId) {
        if (programId == null || programId <= 0L) {
            return null;
        }
        return programRepository.findById(programId);
    }

    @Override
    public List<Program> findAll() {
        return programRepository.findAll();
    }

    // 🔎 VALIDACIÓN CORRECTA
    private boolean isInvalidProgram(Program program) {
        return program == null
                || isBlank(program.getCode())
                || isBlank(program.getName());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}