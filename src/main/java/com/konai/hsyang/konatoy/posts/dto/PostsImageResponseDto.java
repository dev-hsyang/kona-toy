package com.konai.hsyang.konatoy.posts.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsImageResponseDto {

    private String filename;

    public PostsImageResponseDto(String filename){
        this.filename = filename;
    }
}
