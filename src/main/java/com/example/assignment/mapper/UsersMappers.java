package com.example.assignment.mapper;

import com.example.assignment.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersMappers {

    @Select("select * from user")
    List<Users> findAll();

}
