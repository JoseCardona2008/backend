package cesde.edu.ga.service.impl;

import cesde.edu.ga.exceptions.UserExceptions;
import cesde.edu.ga.model.User;
import cesde.edu.ga.repository.UserRepository;
import cesde.edu.ga.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User create(User user) {
        validateUser(user, false);
        User created = userRepository.create(user);
        if (created == null) {
            throw new UserExceptions("Error al crear el usuario. Probablemente conflicto de username o email.");
        }
        return created;
    }
    @Override
    public boolean update(User user) {
        if (user == null) {
            throw new UserExceptions("User cannot be null");
        }
        if (user.getUserId() == null || user.getUserId() <= 0L) {
            throw new UserExceptions("User id is invalid");
        }
        validateUser(user, true);
        return userRepository.update(user);
    }
    @Override
    public boolean delete(Long userId) {
        if (userId == null || userId <= 0L) {
            throw new UserExceptions("User id is invalid");
        }
        return userRepository.delete(userId);
    }
    @Override
    public User findById(Long userId) {
        if (userId == null || userId <= 0L) {
            throw new UserExceptions("User id is invalid");
        }
        User user = userRepository.findById(userId);
        if (user == null) {
            throw UserExceptions.noEncontrado(userId);
        }
        return user;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public User findByUsername(String username) {
        if (username == null || username.trim().isBlank()) {
            throw new UserExceptions("Username cannot be null or empty");
        }
        return userRepository.findByUsername(username);
    }
    @Override
    public User findByEmail(String email) {
        if (email == null || email.trim().isBlank()) {
            throw new UserExceptions("Email cannot be null or empty");
        }
        return userRepository.findByEmail(email);
    }
    private void validateUser(User user, boolean isUpdate) {
        if (user == null) {
            throw new UserExceptions("User cannot be null");
        }
        if (isBlank(user.getUsername())) {
            throw new UserExceptions("El nombre de usuario es obligatorio");
        }
        if (isBlank(user.getPasswordHash())) {
            throw UserExceptions.contrasenaInvalida();
        }
        if (isBlank(user.getEmail())) {
            throw new UserExceptions("El correo electrónico es obligatorio");
        }
        if (isBlank(user.getStatus())) {
            throw new UserExceptions("El estado es obligatorio");
        }
        // Validar username único
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            if (!isUpdate || !existingUser.getUserId().equals(user.getUserId())) {
                throw UserExceptions.usernameDuplicado(user.getUsername());
            }
        }
        // Validar email único
        User existingEmail = userRepository.findByEmail(user.getEmail());
        if (existingEmail != null) {
            if (!isUpdate || !existingEmail.getUserId().equals(user.getUserId())) {
                throw new UserExceptions("Ya existe un usuario con el correo electrónico: " + user.getEmail());
            }
        }
    }
    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}