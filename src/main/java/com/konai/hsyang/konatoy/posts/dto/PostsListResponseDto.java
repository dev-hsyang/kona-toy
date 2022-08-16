package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.posts.domain.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private Long userID;
    private String modifieddate;
    private Long clubID;
    private Long hits;
    private Long likes;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.userID = entity.getUserID();
        this.modifieddate = entity.getModifieddate();
        this.clubID = entity.getClubID();
        this.hits = entity.getHits();
        this.likes = entity.getLikes();
    }
}
