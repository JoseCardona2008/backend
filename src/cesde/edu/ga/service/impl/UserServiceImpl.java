package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.User;
import cesde.edu.ga.repository.UserRepository;
import cesde.edu.ga.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        if (isInvalidUser(user)) {
            return null;
        }
        return userRepository.create(user);
    }

    @Override
    public boolean update(User user) {
        if (isInvalidUser(user)
                || user.getUserId() == null
                || user.getUserId() <= 0L) {
            return false;
        }
        return userRepository.update(user);
    }

    @Override
    public boolean delete(Long userId) {
        if (userId == null || userId <= 0L) {
            return false;
        }
        return userRepository.delete(userId);
    }

    @Override
    public User findById(Long userId) {
        if (userId == null || userId <= 0L) {
            return null;
        }
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        if (username == null || username.trim().isBlank()) {
            return null;
        }
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        if (email == null || email.trim().isBlank()) {
            return null;
        }
        return userRepository.findByEmail(email);
    }

    private boolean isInvalidUser(User user) {
        return user == null
                || isBlank(user.getUsername())
                || isBlank(user.getEmail())
                || isBlank(user.getPasswordHash())
                || isBlank(user.getStatus())
                || isBlank(user.getCreatedAt());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}
