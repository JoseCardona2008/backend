package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.User;
import cesde.edu.ga.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryInMemory implements UserRepository {

    private List<User> users;
    private Long nextUserId;

    public UserRepositoryInMemory(){
        this.users = new ArrayList<>();
        this.nextUserId = 1L;
    }

    @Override
    public User create(User user){

        if (user == null){
            return null;
        }

        if (existsByUsername(user.getUsername())){
            return null;
        }

        if (existsByEmail(user.getEmail())){
            return null;
        }

        user.setUserId(nextUserId++);
        users.add(user);
        return user;
    }

    @Override
    public boolean existsByUsername(String username) {
        if (username == null || username.isEmpty()){
            return false;
        }
        return findByUsername(username) != null;
    }

    @Override
    public boolean existsByEmail(String email) {
        if (email == null || email.isEmpty()){
            return false;
        }
        return findByEmail(email) != null;
    }

    @Override
    public User findByUsername(String username) {
        if (username == null || username.isBlank()){
            return null;
        }

        for (User user : users) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        if (email == null || email.isBlank()){
            return null;
        }

        for (User user : users) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public User findById(Long userId) {
        if (userId == null || userId <= 0){
            return null;
        }
        for (User user : users) {
            if (userId.equals(user.getUserId())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long userId) {
        User user = findById(userId);
        if (user == null) return false;
        users.remove(user);
        return true;
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public boolean update(User updatedUser) {
        if (updatedUser == null) return false;
        
        User existingUser = findById(updatedUser.getUserId());
        if (existingUser == null) return false;
        
        User userWithSameUsername = findByUsername(updatedUser.getUsername());
        if (userWithSameUsername != null && !userWithSameUsername.getUserId().equals(updatedUser.getUserId())) {
            return false;
        }
        
        User userWithSameEmail = findByEmail(updatedUser.getEmail());
        if (userWithSameEmail != null && !userWithSameEmail.getUserId().equals(updatedUser.getUserId())) {
            return false;
        }

        for (int i = 0; i < users.size(); i++) {
            if (updatedUser.getUserId().equals(users.get(i).getUserId())) {
                users.set(i, updatedUser);
                return true;
            }
        }
        return false;
    }
}
