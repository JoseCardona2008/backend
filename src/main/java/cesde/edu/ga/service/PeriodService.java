package cesde.edu.ga.service;

import cesde.edu.ga.model.Period;
import java.util.List;

public interface PeriodService {

    Period create(Period period);

    boolean update(Period period);

    boolean delete(Long periodId);

    Period findById(Long periodId);

    List<Period> findAll();

    Period findByCode(String code);

    boolean existsByCode(String code);
}
