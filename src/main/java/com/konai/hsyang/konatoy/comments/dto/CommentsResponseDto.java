package com.konai.hsyang.konatoy.comments.dto;

import com.konai.hsyang.konatoy.comments.domian.Comments;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentsResponseDto {

    private Long commentsID;
    private Long postID;
    private String nickname;
    private String content;
    private LocalDateTime createdate;
    private LocalDateTime modifieddate;

    @QueryProjection
    public CommentsResponseDto(Comments entity){
        this.commentsID = entity.getCommentsID();
        this.content = entity.getContent();
        this.nickname = entity.getUser().getNickname();
        this.postID = entity.getPost().getPostsID();
        this.createdate = entity.getCreatedate();
        this.modifieddate = entity.getModifieddate();
    }
}
