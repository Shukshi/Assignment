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

//    @Select("select videoId title description publishedAt channelTitle from video order by publishedAT desc limit 20")
//    List<SearchResponse> findAll();

//    @Select("select videoId title description publishedAt channelTitle from video where videoTitle like #{videoTitle}")
//    SearchResponse findByTitle(@Param("videoTitle") String videoTitle);
//
//    @Select("select videoId title description publishedAt channelTitle from video where videoDescription like #{videoDescription}")
//    SearchResponse findByDescription(@Param("videoDescription") String videoDescription);

    @Select ("<script> select videoId title description publishedAt channelTitle from video order by publishedAT desc " +
            "<if title != null>" +
            "where title like #{title} " +
            "</if> " +
            "<if description != null> " +
            "where description like #{description}" +
            "</if> " +
            "limit 20" +
            "</script>")
    List<SearchResponse> findByParameter(@Param("title") String title, @Param("description") String description);

}
