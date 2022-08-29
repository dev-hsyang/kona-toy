package com.konai.hsyang.konatoy.login.controller;

import com.konai.hsyang.konatoy.login.dto.UserJoinRequestDto;
import com.konai.hsyang.konatoy.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class JoinApiController {

    private final UserService userService;

    @PostMapping("/api/join")
    public Long join(@RequestBody UserJoinRequestDto requestDto){

//        if(userService.duplicateID(requestDto.getUsername()))
//            return -1L;
//
//        if(userService.duplicateNick(requestDto.getNickname()))
//            return -2L;

        return userService.join(requestDto);
//        userService.join(requestDto);
//
//        return "redirect:/loginForm";
    }

    @GetMapping("/api/join/checkId")
    public int validateUsername(@RequestParam("username") String username){
        return userService.duplicateID(username);
    }

    @GetMapping("/api/join/checkNick")
    public int validateNickname(@RequestParam("nickname") String nickname){
        return userService.duplicateNick(nickname);
    }
}
