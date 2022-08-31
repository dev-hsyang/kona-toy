package com.konai.hsyang.konatoy.mypage.controller;

import com.konai.hsyang.konatoy.exceptions.NoUserFoundException;
import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.login.service.UserService;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MypageController {

    private final PostsService postsService;
    private final UserService userService;

    @GetMapping("/mypage")
    public String myPage(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){

        model.addAttribute("nickname", principalDetails.getNickname());
        return "mypage";
    }

    @GetMapping("/mypage/posts")
    public String myPosts(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){

        model.addAttribute("userPosts", postsService.findAllDescById(principalDetails.getId()));
        model.addAttribute("nickname", principalDetails.getNickname());
        return "mypage-posts";
    }

    @GetMapping("/mypage/update")
    public String updateMe(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){

        model.addAttribute("user", userService.findByUsername(principalDetails.getUsername()).orElseThrow(()-> new NoUserFoundException()));
        return "mypage-update";
    }

    @GetMapping("/mypage/delete")
    public String deleteMe(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){

        model.addAttribute("userID", principalDetails.getId());
        return "mypage-delete";
    }
}
