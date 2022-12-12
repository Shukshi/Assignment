package com.example.assignment.mapper;

import com.example.assignment.response.SearchResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SearchMapper {
    @Select ("<script> select * from video" +
            "<if test='title != null'>" +
            " where title like #{title} " +
            "</if> " +
            "<if test='description != null'> " +
            " where description like #{description}" +
            "</if> " +
            " order by publishedAT desc limit 20" +
            "</script>")
    List<SearchResponse> findByParameter(@Param("title") String title, @Param("description") String description);

}
