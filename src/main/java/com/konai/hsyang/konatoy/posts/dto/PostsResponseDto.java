package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.posts.domain.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private Long userID;
    private Long commentID;
    private Long fileID;
    private Long locID;
    private String title;
    private String content;
    private Long hits;
    private Long likes;
    private String createdate;
    private String modifieddate;

    public PostsResponseDto(Posts entity){
        this.id = entity.getPostsID();
        this.userID = entity.getUser().getUserID();
        this.fileID = entity.getFile();
        this.locID = entity.getLoc();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.hits = entity.getHits();
        this.likes = entity.getLikes();
        this.createdate = entity.getCreatedate();
        this.modifieddate = entity.getModifieddate();
    }
}