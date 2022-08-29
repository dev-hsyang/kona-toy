package com.konai.hsyang.konatoy.mypage.controller;

import com.konai.hsyang.konatoy.exceptions.NoUserFoundException;
import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.login.domain.User;
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
    public String info(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        String nickname = principalDetails.getNickname();
        model.addAttribute("nickname", nickname);
        return "mypage";

    }

    @GetMapping("/mypage/posts")
    public String infoPosts(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        Long userID = principalDetails.getId();
        model.addAttribute("userPosts", postsService.findAllDescById(userID));
        model.addAttribute("nickname", principalDetails.getNickname());
        return "mypage-posts";
    }

    @GetMapping("/mypage/update")
    public String updateUser(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        String username = principalDetails.getUsername();
        User findUser = userService.findByUsername(username).orElseThrow(()-> new NoUserFoundException());
        model.addAttribute("user", findUser);
        return "mypage-update";
    }

    @GetMapping("/mypage/delete")
    public String deleteUser(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("userID", principalDetails.getId());
        System.out.println(principalDetails.getId());
        return "mypage-delete";
    }
}
