package com.example.bookstorespring.controller;

import com.example.bookstorespring.dto.UserDTO;
import com.example.bookstorespring.request.UserRequest;
import com.example.bookstorespring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserRequest user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok((userService.getOneUserByUsername(username)));
    }

    @PutMapping
    public ResponseEntity<UserDTO> editUser(@RequestBody UserRequest user, @PathVariable Long id) {
        return ResponseEntity.ok(userService.editUser(user, id));
    }

    @DeleteMapping
    public void deleteUser(long id) {
        userService.deleteUser(id);
    }

}
