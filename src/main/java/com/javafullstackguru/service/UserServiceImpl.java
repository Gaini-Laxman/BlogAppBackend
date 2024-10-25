package com.javafullstackguru.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javafullstackguru.entity.User;
import com.javafullstackguru.exception.ResourceNotFoundException;
import com.javafullstackguru.repository.UserRepositoty;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoty userRepositoty;

    @Override
    public User createUser(User user) { 

        return userRepositoty.save(user);
    }

    @Override
    public User findByUserId(Integer id) {
        Optional<User> user = userRepositoty.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException("User Not Found With Id : " + id));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepositoty.findAll();
    }

    @Override
    public User updateUser(Integer id, User user) {
        // Check if the user exists before updating
        if (!userRepositoty.existsById(id)) {
            throw new ResourceNotFoundException("User Not Found with id: " + id);
        }
        user.setId(id); // Ensure the ID is set for the update
        return userRepositoty.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        // Check if the user exists before deleting
        if (!userRepositoty.existsById(id)) {
            throw new ResourceNotFoundException("User Not Found with id: " + id);
        }
        userRepositoty.deleteById(id);
    }
}
