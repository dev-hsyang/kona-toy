package com.konai.hsyang.konatoy.comments.domian;

import com.konai.hsyang.konatoy.comments.dto.CommentsUpdateRequestDto;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.etc.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Comments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentsID;

    @ManyToOne
    @JoinColumn(name="post")
    private Posts post;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    private String content;

    public void update(CommentsUpdateRequestDto requestDto) {

        this.content = requestDto.getContent();
    }
}

