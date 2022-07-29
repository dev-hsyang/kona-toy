package com.konai.hsyang.konatoy.login.controller;

import com.konai.hsyang.konatoy.login.dto.UserJoinRequestDto;
import com.konai.hsyang.konatoy.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginApiController {

    private final UserService userService;

    @PostMapping("/api/join")
    public Long join(@RequestBody UserJoinRequestDto requestDto){
        if(userService.duplicateID(requestDto.getUsername()))
            return -1L;

        if(userService.duplicateNick(requestDto.getNickname()))
            return -2L;

        return userService.join(requestDto);
    }
}
