package com.example.assignment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    private String videoId;
    private String etag;
    private String publishedAt;
    private String channelId;
    private String channelTitle;
}
