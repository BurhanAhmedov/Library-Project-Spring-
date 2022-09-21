package com.example.bookstorespring.service;

import com.example.bookstorespring.dto.UserDTO;
import com.example.bookstorespring.request.UserRequest;

import java.util.List;


public interface UserService {

    UserDTO createUser(UserRequest userRequest);

    UserDTO getOneUserByUsername(String username);

    UserDTO getUserById(long id);

    List<UserDTO> getAllUser();

    UserDTO editUser(UserRequest userRequest, long id);

    void deleteUser(long id);


}
