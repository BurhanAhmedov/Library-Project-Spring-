package com.example.bookstorespring.service;

import com.example.bookstorespring.dto.UserDTO;
import com.example.bookstorespring.mapper.UserDTOMapper;
import com.example.bookstorespring.mapper.UserRequestMapper;
import com.example.bookstorespring.model.Role;
import com.example.bookstorespring.model.User;
import com.example.bookstorespring.repository.RoleRepository;
import com.example.bookstorespring.repository.UserRepository;
import com.example.bookstorespring.request.UserRequest;
import com.example.bookstorespring.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDTO createUser(UserRequest userRequest) {
        User user = UserRequestMapper.mapFromRequest(userRequest);

        List<Role> roleList = roleRepository.findAllById(userRequest.getRoleIds());

        if (!roleList.isEmpty()) {
            user.setRoleList(roleList);
        } else {
            throw new NullPointerException("Role not found!");
        }
        userRepository.save(user);
        UserDTO userDTO = UserDTOMapper.mapFromUser(user);

        return userDTO;
    }

    @Override
    public UserDTO getOneUserByUsername(String username) {
        UserDTO userDTO = new UserDTO();
        User user = userRepository.findByUsername(username);
        if (user != null) {
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        } else
            throw new NullPointerException("User not found by {}" + username);

    }

    @Override
    public UserDTO getUserById(long id) {
        UserDTO userDTO = new UserDTO();
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        } else
            throw new NullPointerException("User not found by " + id);

    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = userList.stream().map(UserDTOMapper::mapFromUser).collect(Collectors.toList());
        if (!userDTOList.isEmpty()) {
            return userDTOList;
        } else
            throw new NullPointerException("User list is empty!");
    }

    @Override
    public UserDTO editUser(UserRequest userRequest, long id) {
        Optional<User> findingUser = userRepository.findById(id);

        if (findingUser.isPresent()) {
            User user = findingUser.get();
            User userFromRequest = UserRequestMapper.mapFromRequest(userRequest);
            user.setId(userFromRequest.getId());
            user.setUsername(userFromRequest.getUsername());
            user.setPassword(userRequest.getPassword());

            userRepository.save(user);

            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;

        } else {
            throw new NullPointerException("User not found by " + id);
        }

    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            log.info("User found in database : {}", username);
            JwtUserDetails userDetails = JwtUserDetails.createUserDetails(user);
            return userDetails;
        } else {
            log.error("User not found in database!");
            throw new UsernameNotFoundException("User not found in database!");
        }


    }
}
