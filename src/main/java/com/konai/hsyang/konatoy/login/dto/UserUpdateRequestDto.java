package com.konai.hsyang.konatoy.login.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String nickname;
    private String oldPassword;
    private String newPassword;

    @Builder
    public UserUpdateRequestDto(String nickname){
        this.nickname = nickname;
    }

    public void setEncPassword(String encPassword){
        this.newPassword = encPassword;
    }
}
