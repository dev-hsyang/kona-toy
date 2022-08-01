package com.konai.hsyang.konatoy.login.controller;

import com.konai.hsyang.konatoy.board.service.PostsService;
import com.konai.hsyang.konatoy.login.dto.UserJoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/joinForm")
    public String join(){
        return "joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("posts", postsService.findAllDesc());

        return "index";
    }
}