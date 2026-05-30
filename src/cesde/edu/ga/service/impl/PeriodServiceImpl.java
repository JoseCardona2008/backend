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
        if (period == null) {
            throw new PeriodExceptions("Period cannot be null");
        }

        if (isInvalidPeriod(period)) {
            throw new PeriodExceptions("Invalid period data");
        }

        return periodRepository.create(period);
    }

    @Override
    public boolean update(Period period) {
        if (period == null) {
            throw new PeriodExceptions("Period cannot be null");
        }

        if (period.getPeriodId() == null || period.getPeriodId() <= 0L) {
            throw new PeriodExceptions("Period id is invalid");
        }

        if (isInvalidPeriod(period)) {
            throw new PeriodExceptions("Invalid period data");
        }

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

    private boolean isInvalidPeriod(Period period) {
        return isBlank(period.getCode())
                || isBlank(period.getStartDate())
                || isBlank(period.getEndDate());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}