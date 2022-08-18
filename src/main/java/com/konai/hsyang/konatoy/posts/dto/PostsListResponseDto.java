package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import lombok.Getter;

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
        this.id = entity.getPostsID();
        this.title = entity.getTitle();
        this.userID = entity.getUser().getUserID();
        this.modifieddate = entity.getModifieddate();
        this.clubID = entity.getClub();
        this.hits = entity.getHits();
        this.likes = entity.getLikes();
    }
}
