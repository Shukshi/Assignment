package com.example.assignment;

import com.example.assignment.mapper.SearchMapper;
import com.example.assignment.response.SearchResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/search")
@Component
public class GetSearchController {
    private final SearchMapper searchMapper;

    public GetSearchController(SearchMapper searchMapper) {
        this.searchMapper = searchMapper;
    }

//    @GetMapping
//    public List<SearchResponse> findAllVideo (@RequestParam(name="title",required=false)String title, @RequestParam(name="description",required=false)String description){
//        return searchMapper.findAll();
//    }
//
//    @GetMapping
//    public SearchResponse findByTitleVideo(String title) {
//        return searchMapper.findByTitle(title);
//    }
//
//    @GetMapping
//    public SearchResponse findByDescriptionVideo(String description) {
//        return searchMapper.findByDescription(description);
//    }

    @GetMapping
    public List<SearchResponse> findByParameters(@RequestParam(name="title",required=false)String title, @RequestParam(name="description",required=false)String description){
//        if(Objects.nonNull(title)){
//            return searchMapper.findByTitle(title);
//        } else if (Objects.nonNull(description)) {
//            return searchMapper.findByDescription(description);
//        }
//        else{
//            return searchMapper.findAll();
//        }
        return searchMapper.findByParameter(title, description);
    }
}
