package cesde.edu.ga.repository;

import cesde.edu.ga.model.User;
import java.util.List;

public interface UserRepository {

    User create(User user);

    List<User> findAll();

    User findById(Long userId);

    User findByUsername(String username);

    User findByEmail(String email);

    boolean update(User updatedUser);

    boolean delete(Long userId);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    int count();
}
