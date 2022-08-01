package com.konai.hsyang.konatoy.board.dto;

import com.konai.hsyang.konatoy.board.domain.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private Long userID;
    private LocalDateTime modifieddate;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.userID = entity.getUserID();
        this.modifieddate = entity.getModifieddate();
    }
}
