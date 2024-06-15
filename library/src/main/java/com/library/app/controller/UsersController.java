package com.library.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.app.entity.Users;
import com.library.app.service.UsersService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public Users createAdmin(@RequestBody Users users) {
        return usersService.createUser(users);
    }

    @GetMapping("/fetch/{id}")
    public Optional<Users> getById(@PathVariable Long id) {
        return usersService.getUserById(id);
    }

    @GetMapping("/fetchAll")
    public List<Users> findAllAdmin() {
        return usersService.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public Users updateAdmin(@RequestBody Users users, @PathVariable Long id) {
        return usersService.updateUserById(users, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        return usersService.deleteById(id);
    }
}
