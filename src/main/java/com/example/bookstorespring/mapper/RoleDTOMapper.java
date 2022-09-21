package com.example.bookstorespring.mapper;

import com.example.bookstorespring.dto.RoleDTO;
import com.example.bookstorespring.model.Role;

public class RoleDTOMapper {
    public static RoleDTO mapFromRole(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setRole_name(role.getRoleName());
        return roleDTO;

    }


}
