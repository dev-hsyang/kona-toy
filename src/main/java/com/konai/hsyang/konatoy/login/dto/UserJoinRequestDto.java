package com.konai.hsyang.konatoy.login.dto;

import com.konai.hsyang.konatoy.login.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserJoinRequestDto {

    private Long clubID;
    private String username;
    private String password;
    private String nickname;

    @Builder
    public UserJoinRequestDto(Long clubID, String userName, String userPw, String userNickName) {

        this.clubID = clubID;
        this.username = userName;
        this.password = userPw;
        this.nickname = userNickName;
    }

    public User toEntity(){
        return User.builder()
                .clubID(clubID)
                .userName(username)
                .userPw(password)
                .userNickname(nickname)
                .build();
    }

    public void setEncPassword(String encPassword){
        this.password = encPassword;
    }
}
