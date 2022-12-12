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

    @Select("select * from video order by publishedAT desc limit 10")
    List<SearchResponse> findAll();

    @Select("select * from video where title like #{videoTitle}")
    List <SearchResponse> findByTitle(@Param("videoTitle") String videoTitle);

    @Select("select * from video where description like #{videoDescription}")
    List<SearchResponse> findByDescription(@Param("videoDescription") String videoDescription);

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
