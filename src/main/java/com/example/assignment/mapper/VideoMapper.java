package com.example.assignment.mapper;

import com.example.assignment.model.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Mapper
@Component
public interface VideoMapper {
    @Select("insert into video (videoId, etag, publishedAt, channelID, channelTitle, title, description) Values (#{videoId}, " +
            "#{etag}, #{publishedAt}, #{channelID}, #{channelTitle}, #{title}, #{description})")
    void insertData(@Param("videoId") String videoId, @Param("etag") String etag,
                    @Param("publishedAt") Timestamp timestamp, @Param("channelID") String channelId,
                    @Param("channelTitle")String ChannelTitle, @Param("title") String title, @Param("description") String description);


    @Select("Select * from video where videoId = #{videoId}")
    Video getVideoById(@Param("videoId") String videoId);

    @Select("Select publishedAt from video order by publishedAt desc limit 1")
    Timestamp getLastUpdatedTime();
}
