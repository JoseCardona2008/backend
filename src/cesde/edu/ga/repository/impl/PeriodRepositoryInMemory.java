package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.Period;
import cesde.edu.ga.repository.PeriodRepository;
import java.util.ArrayList;
import java.util.List;

public class PeriodRepositoryInMemory implements PeriodRepository {

    private List<Period> periods;
    private Long nextPeriodId;

    public PeriodRepositoryInMemory() {
        this.periods = new ArrayList<>();
        this.nextPeriodId = 1L;
    }

    @Override
    public Period create(Period period) {
        if (period == null) {
            return null;
        }

        if (existsByCode(period.getCode())) {
            return null;
        }

        period.setPeriodId(nextPeriodId++);
        periods.add(period);
        return period;
    }

    @Override
    public boolean existsByCode(String code) {
        if (code == null || code.isBlank()) {
            return false;
        }
        return findByCode(code) != null;
    }

    @Override
    public List<Period> findAll() {
        return new ArrayList<>(periods);
    }

    @Override
    public Period findById(Long periodId) {
        if (periodId == null || periodId <= 0) {
            return null;
        }
        for (Period period : periods) {
            if (periodId.equals(period.getPeriodId())) {
                return period;
            }
        }
        return null;
    }

    @Override
    public Period findByCode(String code) {
        if (code == null || code.isBlank()) {
            return null;
        }
        for (Period period : periods) {
            if (code.equals(period.getCode())) {
                return period;
            }
        }
        return null;
    }

    @Override
    public boolean update(Period updatedPeriod) {
        if (updatedPeriod == null) {
            return false;
        }

        if (findByCode(updatedPeriod.getCode()) != null) {
            return false;
        }

        for (int i = 0; i < periods.size(); i++) {
            if (updatedPeriod.getPeriodId().equals(periods.get(i).getPeriodId())) {
                periods.set(i, updatedPeriod);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long periodId) {
        Period period = findById(periodId);
        if (period == null) {
            return false;
        }
        periods.remove(period);
        return true;
    }

    @Override
    public int count() {
        return periods.size();
    }
}
