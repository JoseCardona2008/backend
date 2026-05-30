package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Program;
import cesde.edu.ga.repository.ProgramRepository;
import cesde.edu.ga.service.ProgramService;
import cesde.edu.ga.exceptions.ProgramExceptions;

import java.util.List;

public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program create(Program program) {
        if (program == null) {
            throw new ProgramExceptions("Program cannot be null");
        }

        if (isInvalidProgram(program)) {
            throw new ProgramExceptions("Invalid program data");
        }

        return programRepository.create(program);
    }

    @Override
    public boolean update(Program program) {
        if (program == null) {
            throw new ProgramExceptions("Program cannot be null");
        }

        if (program.getProgramId() == null || program.getProgramId() <= 0L) {
            throw new ProgramExceptions("Program id is invalid");
        }

        if (isInvalidProgram(program)) {
            throw new ProgramExceptions("Invalid program data");
        }

        return programRepository.update(program);
    }

    @Override
    public boolean delete(Long programId) {
        if (programId == null || programId <= 0L) {
            throw new ProgramExceptions("Program id is invalid");
        }

        return programRepository.delete(programId);
    }

    @Override
    public Program findById(Long programId) {
        if (programId == null || programId <= 0L) {
            throw new ProgramExceptions("Program id is invalid");
        }

        Program program = programRepository.findById(programId);

        if (program == null) {
            throw ProgramExceptions.noEncontrado(programId);
        }

        return program;
    }

    @Override
    public List<Program> findAll() {
        return programRepository.findAll();
    }

    private boolean isInvalidProgram(Program program) {
        return isBlank(program.getCode())
                || isBlank(program.getName());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}