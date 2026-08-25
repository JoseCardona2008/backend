package cesde.edu.ga.service;

import cesde.edu.ga.model.User;
import java.util.List;

public interface UserService {

    User create(User user);

    boolean update(User user);

    boolean delete(Long userId);

    User findById(Long userId);

    List<User> findAll();

    User findByUsername(String username);

    User findByEmail(String email);
}
