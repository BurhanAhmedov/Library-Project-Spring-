package com.example.bookstorespring.mapper;

import com.example.bookstorespring.dto.RoleDTO;
import com.example.bookstorespring.dto.UserDTO;
import com.example.bookstorespring.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTOMapper {
    public static UserDTO mapFromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());

        List<RoleDTO> roleDTOList = mapRoleList(user);
        userDTO.setRoleList(roleDTOList);

        return userDTO;
    }

    public static List<RoleDTO> mapRoleList(User user) {
        List<RoleDTO> roleDTOList = user.getRoleList().stream()
                .map(RoleDTOMapper::mapFromRole)
                .collect(Collectors.toList());

        return roleDTOList;
    }


}
