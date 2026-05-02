package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Period;
import cesde.edu.ga.repository.PeriodRepository;
import cesde.edu.ga.service.PeriodService;
import java.util.List;

public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;

    public PeriodServiceImpl(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    @Override
    public Period create(Period period) {
        if (isInvalidPeriod(period)) {
            return null;
        }
        return periodRepository.create(period);
    }

    @Override
    public boolean update(Period period) {
        if (isInvalidPeriod(period)
                || period.getPeriodId() == null
                || period.getPeriodId() <= 0L) {
            return false;
        }
        return periodRepository.update(period);
    }

    @Override
    public boolean delete(Long periodId) {
        if (periodId == null || periodId <= 0L) {
            return false;
        }
        return periodRepository.delete(periodId);
    }

    @Override
    public Period findById(Long periodId) {
        if (periodId == null || periodId <= 0L) {
            return null;
        }
        return periodRepository.findById(periodId);
    }

    @Override
    public List<Period> findAll() {
        return periodRepository.findAll();
    }

    @Override
    public Period findByCode(String code) {
        if (code == null || code.trim().isBlank()) {
            return null;
        }
        return periodRepository.findByCode(code);
    }

    @Override
    public boolean existsByCode(String code) {
        if (code == null || code.trim().isBlank()) {
            return false;
        }
        return periodRepository.existsByCode(code);
    }

    private boolean isInvalidPeriod(Period period) {
        return period == null
                || isBlank(period.getCode())
                || isBlank(period.getStartDate())
                || isBlank(period.getEndDate());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}
