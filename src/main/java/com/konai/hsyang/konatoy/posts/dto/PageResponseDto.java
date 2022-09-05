package com.konai.hsyang.konatoy.posts.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageResponseDto {

    private String nickname;
    private String title;

    @Builder
    public PageResponseDto(String nickname, String title){

        this.nickname = nickname;
        this.title = title;
    }

    public void setPageDefault(){

        this.nickname = null;
        this.title = null;
    }
}
