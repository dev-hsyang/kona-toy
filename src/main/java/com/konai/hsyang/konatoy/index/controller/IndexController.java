package com.konai.hsyang.konatoy.index.controller;

import com.konai.hsyang.konatoy.index.service.IndexService;
import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.login.service.UserService;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final UserService userService;
    private final IndexService indexService;

    @GetMapping("/")
    public String index(Model model) {

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("Auth::: " + auth.getPrincipal());
//        model.addAttribute("auth", auth.getPrincipal()!="anonymousUser");
//        System.out.println(auth.getPrincipal()!="anonymousUser");
        return "index";
    }

    @GetMapping("/board")
    public String board(@RequestParam(defaultValue = "s1") String sort, Model model){
        if(sort.equals("s1")) {
            model.addAttribute("posts", postsService.findAllDescCurrent());
            return "board";
        } else if (sort.equals("s2")) {
            model.addAttribute("posts", postsService.findAllDescHits());
            return "board";
        } else if (sort.equals("s3")) {
            model.addAttribute("posts", postsService.findAllDescLikes());
            return "board";
        }
        return "index";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/userInfo")
    public String info(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("nickname", principalDetails.getNickname());
        return "userInfo";
    }

    @GetMapping("/userInfo/posts")
    public String infoPosts(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        Long userID = principalDetails.getId();
        model.addAttribute("userPosts", postsService.findAllDescById(userID));
        model.addAttribute("nickname", principalDetails.getNickname());
        return "userInfo-posts";
    }

//    @GetMapping("/board")
//    public String board(@RequestParam(defaultValue = "s1") String sort, Model model){
//        if(sort.equals("s1")) {
//            model.addAttribute("posts", postsService.findAllDescCurrent());
//            return "board";
//        } else if (sort.equals("s2")) {
//            model.addAttribute("posts", postsService.findAllDescHits());
//            return "board";
//        } else if (sort.equals("s3")) {
//            model.addAttribute("posts", postsService.findAllDescLikes());
//            return "board";
//        }
//        return "index";
//    }


}
