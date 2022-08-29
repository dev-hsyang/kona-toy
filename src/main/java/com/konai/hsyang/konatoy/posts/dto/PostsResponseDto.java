package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long postID;
    private User user;
    private String club;
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
        this.postID = entity.getPostsID();
        this.user = entity.getUser();
        this.fileID = entity.getFile();
        this.locID = entity.getLoc();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.hits = entity.getHits();
        this.likes = entity.getLikes();
        this.createdate = entity.getCreatedate();
        this.modifieddate = entity.getModifieddate();
        this.club = entity.getUser().getClub().getClubname();
    }
}
