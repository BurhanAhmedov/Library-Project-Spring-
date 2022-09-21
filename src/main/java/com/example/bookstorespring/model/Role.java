package com.example.bookstorespring.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    Long id;

    String roleName;

}
