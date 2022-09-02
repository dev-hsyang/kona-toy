package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String userID;
    private String createdate;
    private String clubID;
    private Long hits;
    private Long likes;

    @QueryProjection
    public PostsListResponseDto(Posts entity){
        this.id = entity.getPostsID();
        this.title = entity.getTitle();
        this.userID = entity.getUser().getNickname();
        this.createdate = entity.getCreatedate();
        this.clubID =entity.getUser().getClub().getClubname();
        this.hits = entity.getHits();
        this.likes = entity.getLikes();
    }
}
