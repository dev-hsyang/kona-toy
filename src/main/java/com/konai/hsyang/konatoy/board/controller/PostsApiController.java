package com.konai.hsyang.konatoy.board.controller;

import com.konai.hsyang.konatoy.board.dto.PostsSaveRequestDto;
import com.konai.hsyang.konatoy.board.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        System.out.println("log");
        return postsService.save(requestDto);
    }
}
