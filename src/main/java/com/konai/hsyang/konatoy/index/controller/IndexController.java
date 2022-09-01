package com.konai.hsyang.konatoy.index.controller;

import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.dto.CustomPageRequest;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping("/board-test")
    public String testboard(Model model){

        model.addAttribute("posts", postsService.getPage(new CustomPageRequest()));
        return "testboard";
    }
}
