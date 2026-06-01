package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Period;
import cesde.edu.ga.repository.PeriodRepository;
import cesde.edu.ga.service.PeriodService;
import cesde.edu.ga.exceptions.PeriodExceptions;

import java.util.List;

public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;

    public PeriodServiceImpl(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    @Override
    public Period create(Period period) {
        validatePeriod(period);

        Period created = periodRepository.create(period);
        if (created == null) {
            throw new PeriodExceptions("Error al crear el período. Probablemente código duplicado.");
        }
        return created;
    }

    @Override
    public boolean update(Period period) {
        if (period == null) {
            throw new PeriodExceptions("Period cannot be null");
        }

        if (period.getPeriodId() == null || period.getPeriodId() <= 0L) {
            throw new PeriodExceptions("Period id is invalid");
        }

        validatePeriod(period);

        return periodRepository.update(period);
    }

    @Override
    public boolean delete(Long periodId) {
        if (periodId == null || periodId <= 0L) {
            throw new PeriodExceptions("Period id is invalid");
        }

        return periodRepository.delete(periodId);
    }

    @Override
    public Period findById(Long periodId) {
        if (periodId == null || periodId <= 0L) {
            throw new PeriodExceptions("Period id is invalid");
        }

        Period period = periodRepository.findById(periodId);

        if (period == null) {
            throw PeriodExceptions.noEncontrado(periodId);
        }

        return period;
    }

    @Override
    public List<Period> findAll() {
        return periodRepository.findAll();
    }

    @Override
    public Period findByCode(String code) {
        if (code == null || code.trim().isBlank()) {
            throw new PeriodExceptions("Code cannot be null or empty");
        }

        return periodRepository.findByCode(code);
    }

    @Override
    public boolean existsByCode(String code) {
        if (code == null || code.trim().isBlank()) {
            throw new PeriodExceptions("Code cannot be null or empty");
        }

        return periodRepository.existsByCode(code);
    }

    private void validatePeriod(Period period) {
        if (period == null) {
            throw new PeriodExceptions("Period cannot be null");
        }

        if (isBlank(period.getCode())) {
            throw new PeriodExceptions("El código del período es obligatorio");
        }

        if (isBlank(period.getStartDate()) || isBlank(period.getEndDate())) {
            throw new PeriodExceptions("Las fechas de inicio y fin son obligatorias");
        }

        try {
            java.time.LocalDate start = java.time.LocalDate.parse(period.getStartDate());
            java.time.LocalDate end = java.time.LocalDate.parse(period.getEndDate());

            if (!start.isBefore(end)) {
                throw PeriodExceptions.fechasInvalidas(period.getStartDate(), period.getEndDate());
            }
        } catch (java.time.format.DateTimeParseException e) {
            throw new PeriodExceptions("Formato de fecha inválido. Debe ser YYYY-MM-DD.");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}