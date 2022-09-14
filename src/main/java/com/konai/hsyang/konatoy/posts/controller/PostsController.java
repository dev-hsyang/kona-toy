package com.konai.hsyang.konatoy.posts.controller;

import com.konai.hsyang.konatoy.comments.service.CommentsService;
import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
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
    private final CommentsService commentsService;

    @GetMapping("/posts/save")
    public String savePost(){

        return "posts-saveV2";
    }

    @GetMapping("/posts/view/{id}")
    public String viewPost(@PathVariable Long id, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){

        postsService.updateHits(id);
        model.addAttribute("post", postsService.postsResponseDtoFindById(id));
        model.addAttribute("comments", commentsService.commentsFindByPost(id));
        model.addAttribute("writer", postsService.isWriter(principalDetails.getId(), postsService.postsResponseDtoFindById(id)));
        return "posts-view";
    }

    @GetMapping("/posts/update/{id}")
    public String updatePost(@PathVariable Long id, Model model){

        model.addAttribute("post", postsService.postsResponseDtoFindById(id));
        return "posts-update";
    }
}
