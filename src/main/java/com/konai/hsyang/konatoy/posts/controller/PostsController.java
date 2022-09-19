package com.konai.hsyang.konatoy.posts.controller;

import com.konai.hsyang.konatoy.comments.dto.CommentsResponseDto;
import com.konai.hsyang.konatoy.comments.service.CommentsService;
import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
    public String viewPost(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model){

        postsService.updateHits(id);
        model.addAttribute("post", postsService.postsResponseDtoFindById(id));
        model.addAttribute("author", postsService.isPostAuthor(principalDetails.getId(), postsService.postsResponseDtoFindById(id)));
        model.addAttribute("comments", commentsService.getCommentsList(principalDetails.getNickname(), id));
        return "posts-view";
    }

    @GetMapping("/posts/update/{id}")
    public String updatePost(@PathVariable Long id, Model model){

        model.addAttribute("post", postsService.postsResponseDtoFindById(id));
        return "posts-update";
    }
}
