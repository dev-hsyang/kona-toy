package com.konai.hsyang.konatoy.mypage.controller;

import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.login.dto.UserUpdateRequestDto;
import com.konai.hsyang.konatoy.login.repository.UserRepository;
import com.konai.hsyang.konatoy.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MypageApiController {

    private final UserService userService;

    @PostMapping("/api/mypage/update-nickname/{id}")
    public Long updateNickname(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto){
        return userService.updateNickname(id, requestDto);
    }

    @PostMapping("/api/mypage/update-password/{id}")
    public Long updatePassword(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto){

        return userService.updatePassword(id, requestDto);
    }

    @PostMapping("/api/mypage/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }
}
