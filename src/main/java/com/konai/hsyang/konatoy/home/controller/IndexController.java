package com.konai.hsyang.konatoy.home.controller;

import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("Auth::: " + auth.getPrincipal());
//        model.addAttribute("auth", auth.getPrincipal()!="anonymousUser");
//        System.out.println(auth.getPrincipal()!="anonymousUser");
        return "index";
    }

    @GetMapping("/board")
    public String board(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "board";
    }

    @GetMapping("/userInfo")
    @ResponseBody
    public String info(Model model){
        return "userInfo";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

}
