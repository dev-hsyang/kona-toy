package com.konai.hsyang.konatoy.index.controller;

import com.konai.hsyang.konatoy.posts.dto.PageResponseDto;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/board")
    public String board(@RequestParam(defaultValue = "date") String sortType, Model model){

        model.addAttribute("posts", postsService.sort(sortType));
        return "board";
    }

    @GetMapping("/loginForm")
    public String loginForm() {

        return "loginForm";
    }

    @GetMapping("/boardV2")
    public String boardV2(@PageableDefault(size=15, sort="createdate") Pageable pageable, Model model, PageResponseDto responseDto){

        model.addAttribute("posts", postsService.getPage(responseDto, pageable));
        return "boardV2";
    }

    @GetMapping("/board-test")
    public String boardTest(){

        return "posts-saveV2";
    }
}
