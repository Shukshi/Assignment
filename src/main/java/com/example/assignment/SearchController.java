package com.example.assignment;

import com.example.assignment.mapper.SearchMapper;
import com.example.assignment.response.SearchResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@Component
public class SearchController {
    private final SearchMapper searchMapper;

    public SearchController(SearchMapper searchMapper) {
        this.searchMapper = searchMapper;
    }

    @GetMapping
    public List<SearchResponse> findAllVideo (@RequestParam(name="title",required=false)String title, @RequestParam(name="description",required=false)String description){
        return searchMapper.findByParameter(title, description);
    }

}
