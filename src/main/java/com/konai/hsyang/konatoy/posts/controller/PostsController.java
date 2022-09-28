package com.konai.hsyang.konatoy.posts.controller;

import com.konai.hsyang.konatoy.comments.service.CommentsService;
import com.konai.hsyang.konatoy.exceptions.NoPostsFoundException;
import com.konai.hsyang.konatoy.location.service.LocationService;
import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.posts.dto.PostsResponseDto;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsService postsService;
    private final CommentsService commentsService;
    private final LocationService locationService;

    @GetMapping("/posts/save")
    public String savePost(){

        return "posts-saveV2";
    }

    @GetMapping("/posts/view/{id}")
    public String viewPost(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model){

        postsService.updateHits(id);
        PostsResponseDto responseDto = postsService.postsResponseDtoFindById(id);
        model.addAttribute("post", responseDto);
        model.addAttribute("author", postsService.isPostAuthor(principalDetails.getId(), postsService.postsResponseDtoFindById(id)));
        model.addAttribute("comments", commentsService.getCommentsList(principalDetails.getNickname(), id)); // 작성자인지 아닌지 판단 위해 responseDto에서 commentsList를 불러오지 않고 별도 함수 호출
        model.addAttribute("location", locationService.findByID(responseDto.getLocation().getLocationID()));
        model.addAttribute("files", responseDto.getFiles());
        return "posts-view";
    }

    @GetMapping("/posts/update/{id}")
    public String updatePost(@PathVariable Long id, Model model){

        model.addAttribute("post", postsService.postsResponseDtoFindById(id));
        return "posts-update";
    }


}
