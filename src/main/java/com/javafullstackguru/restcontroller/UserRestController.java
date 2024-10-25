package com.javafullstackguru.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javafullstackguru.entity.User;
import com.javafullstackguru.exception.ResourceNotFoundException;
import com.javafullstackguru.service.UserService;

//http://localhost:9000/swagger-ui/index.html

@RestController
@RequestMapping("/api/users") // Base URL for user operations
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/createuser") // Create a new user
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = userService.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // Retrieve a user by ID
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        try {
            Integer userId = Integer.valueOf(id);
            User user = userService.findByUserId(userId); // Fetch user by ID
            return ResponseEntity.ok(user); // Return the user if found
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid user ID format");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // Handle user not found
        }
    }

    @GetMapping("/allusers") // Retrieve all users
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}") // Update a user
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // Delete a user
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
