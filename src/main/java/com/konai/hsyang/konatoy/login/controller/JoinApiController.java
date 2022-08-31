package com.konai.hsyang.konatoy.login.controller;

import com.konai.hsyang.konatoy.login.dto.UserJoinRequestDto;
import com.konai.hsyang.konatoy.login.service.ClubService;
import com.konai.hsyang.konatoy.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class JoinApiController {

    private final UserService userService;
    private final ClubService clubService;

    @PostMapping("/api/join")
    public Long join(@RequestParam(required = true) String club, @RequestBody UserJoinRequestDto requestDto){

        clubService.setClub(club, requestDto);
        return userService.join(requestDto);
    }

    @GetMapping("/api/join/checkId")
    public int validateUsername(@RequestParam("username") String username){

        return userService.validateID(username);
    }

    @GetMapping("/api/join/checkNick")
    public int validateNickname(@RequestParam("nickname") String nickname){

        return userService.validateNickname(nickname);
    }
}
