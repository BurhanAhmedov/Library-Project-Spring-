package com.example.bookstorespring.mapper;

import com.example.bookstorespring.model.User;
import com.example.bookstorespring.request.UserRequest;
import org.springframework.beans.BeanUtils;

public class UserRequestMapper {
    public static User mapFromRequest(UserRequest userRequest) {

        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return user;
    }
}
