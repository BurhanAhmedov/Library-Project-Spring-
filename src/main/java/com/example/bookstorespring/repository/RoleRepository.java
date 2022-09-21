package com.example.bookstorespring.repository;

import com.example.bookstorespring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
