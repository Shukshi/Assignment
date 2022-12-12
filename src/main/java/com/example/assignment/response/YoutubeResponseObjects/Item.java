package com.example.assignment.response.YoutubeResponseObjects;

import com.example.assignment.response.YoutubeResponseObjects.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private String kind;
    private String etag;
    private Id id;
    private Snippet snippet;
}
