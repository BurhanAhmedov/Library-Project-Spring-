package com.example.bookstorespring.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequest {
    private long id;
    private String username;
    private String password;
    private List<Long> roleIds;
}
