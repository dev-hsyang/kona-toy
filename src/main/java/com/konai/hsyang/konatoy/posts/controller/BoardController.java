package com.konai.hsyang.konatoy.posts.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {

    @GetMapping("/posts/save")
    public String save(){
        return "posts-save";
    }
}
