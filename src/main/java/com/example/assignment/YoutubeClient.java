package com.example.assignment;

import com.example.assignment.response.YoutubeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name ="youtube-client", url="https://www.googleapis.com/youtube/v3/")
@Component
public interface YoutubeClient {

    @GetMapping("search/")
    YoutubeResponse getYoutubeClient(@RequestParam(value="key") String key, @RequestParam(value="type") String type, @RequestParam(value="order") String order, @RequestParam(value="publishedAfter") String publishedAfter, @RequestParam(value="part") String part);
}
