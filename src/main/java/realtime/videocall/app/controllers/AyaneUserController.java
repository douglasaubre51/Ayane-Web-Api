package realtime.videocall.app.controllers;

import realtime.videocall.app.models.*;
import realtime.videocall.app.repositories.IUserRepository;
import realtime.videocall.app.services.UserService;
import realtime.videocall.app.entities.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AyaneUserController {
    @Autowired
    private IUserRepository _userRepository;

    @Autowired
    private UserService _service;

    @GetMapping("getUserByEmail")
    public ResponseEntity<Boolean> getUserByEmail(@RequestParam String email, @RequestParam String password) {
        boolean isValidAccount = _service.getUserByEmail(email, password);
        System.out.println("account is valid:" + isValidAccount);
        return ResponseEntity.ok().body(isValidAccount);
    }

    @GetMapping("getUser")
    public ResponseEntity<User> getUser(@RequestParam Long id) {
        User user = _userRepository.findById(id).orElse(null);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("addUser")
    public ResponseEntity<User> createNewUser(@RequestBody Person person) {
        System.out.println(person);

        User user = new User();
        user.setName(person.name);
        user.setEmailID(person.email);
        user.setPassword(person.password);

        _userRepository.save(user);

        return ResponseEntity.status(201).body(user);
    }
}