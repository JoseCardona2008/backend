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
        validateProgram(program);

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

        validateProgram(program);

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

    private void validateProgram(Program program) {
        if (program == null) {
            throw new ProgramExceptions("Program cannot be null");
        }
        if (isBlank(program.getName())) {
            throw new ProgramExceptions("El nombre del programa es obligatorio");
        }
        if (isBlank(program.getCode())) {
            throw new ProgramExceptions("El código del programa es obligatorio");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}