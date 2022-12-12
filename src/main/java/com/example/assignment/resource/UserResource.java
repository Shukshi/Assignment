package com.example.assignment.resource;

import com.example.assignment.mapper.UsersMappers;
import com.example.assignment.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

    private UsersMappers userMappers;

    public UserResource(UsersMappers usersMapper) {
        this.userMappers = usersMapper;
    }

    @GetMapping ("/all")
    public List<Users> getAll() {
        return userMappers.findAll();
    }
}
