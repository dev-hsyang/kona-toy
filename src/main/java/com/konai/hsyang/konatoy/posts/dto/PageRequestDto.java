package com.konai.hsyang.konatoy.posts.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageRequestDto {

    private String nickname;
    private String title;

    public void setPageDefault(){

        this.nickname = null;
        this.title = null;
    }
}
