package com.konai.hsyang.konatoy.posts.controller;

import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.posts.dto.PostsResponseDto;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsService postsService;
    @GetMapping("/posts/save")
    public String save(){
        return "posts-save";
    }

    @GetMapping("/posts/view/{id}")
    public String view(@PathVariable Long id, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        postsService.updateHits(id);
        PostsResponseDto dto = postsService.postsFindById(id);
        model.addAttribute("post", dto);

        if(principalDetails.getNickname().equals(dto.getUserID())) {
            return "posts-view-u";
        }
        return "posts-view";
    }

    @GetMapping("/posts/update/{id}")
    public String update(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.postsFindById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
