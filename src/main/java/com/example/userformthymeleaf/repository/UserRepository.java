package com.example.userformthymeleaf.repository;

import com.example.userformthymeleaf.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();
    private int userId;


    private int nextUserId() {
        return ++userId;
    }

    public List<User> getAllUsers(){
        return users;
    }

    public User addUser(User user){
        user.setUserId(nextUserId());
        users.add(user);
        return user;
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    public User updateUsers(User updatedUser) {
        User existingUser = getUserById(updatedUser.getUserId());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setName(updatedUser.getName());
        existingUser.setUserRole(updatedUser.getUserRole());

        return updatedUser;
    }
}
