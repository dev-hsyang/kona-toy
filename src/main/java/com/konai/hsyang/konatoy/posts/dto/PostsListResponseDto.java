package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String userID;
    private LocalDateTime createdate;
    private String formatDate;
    private String clubID;
    private Long hits;
    private Long likes;

    @QueryProjection
    public PostsListResponseDto(Posts entity){
        this.id = entity.getPostsID();
        this.title = entity.getTitle();
        this.userID = entity.getUser().getNickname();
        this.createdate = entity.getCreatedate();
        this.formatDate = entity.getCreatedate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        this.clubID =entity.getUser().getClub().getClubname();
        this.hits = entity.getHits();
        this.likes = entity.getLikes();
    }
}
