package com.example.assignment.service;

import com.example.assignment.YoutubeClient;
import com.example.assignment.mapper.VideoMapper;
import com.example.assignment.model.Video;
import com.example.assignment.response.YoutubeResponse;
import com.example.assignment.response.YoutubeResponseObjects.Item;
import com.example.assignment.response.YoutubeResponseObjects.Snippet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Slf4j
@Component
public class YoutubeService {

    private final YoutubeClient youtubeClient;
    private final VideoMapper videoMapper;

    public YoutubeService(YoutubeClient youtubeClient, VideoMapper videoMapper) {
        this.youtubeClient = youtubeClient;
        this.videoMapper = videoMapper;
    }

    @Scheduled(fixedRate = 10000)
    public void youtubeDataScheduler(){

        Timestamp lastUpdatedTime = videoMapper.getLastUpdatedTime();
        if (Objects.isNull(lastUpdatedTime)) {
            lastUpdatedTime = Timestamp.valueOf("2021-12-10 00:00:00");
        }

        LocalDateTime lastUpdatedLocalDateTime = lastUpdatedTime.toLocalDateTime().plusSeconds(1);
        String publishedAfterFilter = lastUpdatedLocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        publishedAfterFilter += 'Z';

        System.out.println(publishedAfterFilter);

        YoutubeResponse youtubeResponse = youtubeClient.getYoutubeClient("AIzaSyC7yB--Aghsw5HLPHj_pgiJ-A4werr9BL8",
                "video",
                "date",
                publishedAfterFilter,
                "snippet");
        for (Item item : youtubeResponse.getItems()) {
            Snippet snippet = item.getSnippet();
            String strDate = snippet.getPublishedAt();
            strDate = strDate.replace('T', ' ').substring(0, strDate.length()-2);
            Timestamp timeStampDate = Timestamp.valueOf(strDate);
            Video video = videoMapper.getVideoById(item.getId().getVideoId());
            if (Objects.isNull(video)) {
                videoMapper.insertData(item.getId().getVideoId(), item.getEtag(),
                        timeStampDate, snippet.getChannelId(), snippet.getChannelTitle(), snippet.getTitle(), snippet.getDescription());
            }
        }
    }
}
