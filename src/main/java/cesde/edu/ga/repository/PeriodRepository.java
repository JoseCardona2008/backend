package cesde.edu.ga.repository;

import cesde.edu.ga.model.Period;
import java.util.List;

public interface PeriodRepository {

    Period create(Period period);

    List<Period> findAll();

    Period findById(Long periodId);

    Period findByCode(String code);

    boolean update(Period period);

    boolean delete(Long periodId);

    boolean existsByCode(String code);

    int count();
}
