package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.login.domain.Club;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String userID;
    private String modifieddate;
    private String clubID;
    private Long hits;
    private Long likes;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getPostsID();
        this.title = entity.getTitle();
        this.userID = entity.getUser().getNickname();
        this.modifieddate = entity.getModifieddate();
        this.clubID =entity.getUser().getClub().getClubname();
        this.hits = entity.getHits();
        this.likes = entity.getLikes();
    }
}
