package com.konai.hsyang.konatoy.login.controller;

import com.konai.hsyang.konatoy.exceptions.NoClubFoundException;
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
        switch (club){
            case "c1": requestDto.setClubID(clubService.findByClubId(1L).orElseThrow(()-> new NoClubFoundException()));
                break;
            case "c2": requestDto.setClubID(clubService.findByClubId(2L).orElseThrow(()-> new NoClubFoundException()));
                break;
            case "c3": requestDto.setClubID(clubService.findByClubId(3L).orElseThrow(()-> new NoClubFoundException()));
                break;
            case "c4": requestDto.setClubID(clubService.findByClubId(4L).orElseThrow(()-> new NoClubFoundException()));
                break;
            case "c5": requestDto.setClubID(clubService.findByClubId(5L).orElseThrow(()-> new NoClubFoundException()));
                break;
            case "c6": requestDto.setClubID(clubService.findByClubId(6L).orElseThrow(()-> new NoClubFoundException()));
                break;
        }
        return userService.join(requestDto);
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
