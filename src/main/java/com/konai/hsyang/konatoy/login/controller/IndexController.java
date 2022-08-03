package com.konai.hsyang.konatoy.login.controller;

import com.konai.hsyang.konatoy.board.service.PostsService;
import com.konai.hsyang.konatoy.login.config.auth.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

//        SessionUser user = (SessionUser) httpSession.getAttribute("name");
//        System.out.println(user.getUsername());
//        if(user != null)
//            model.addAttribute("userName", user.getUsername());
        return "index";
    }

    @GetMapping("/user/info")
    @ResponseBody
    public String info(Model model){
        return "userInfo";
    }

    @GetMapping("/sample")
    public String sample(){
        return "sample";
    }
}