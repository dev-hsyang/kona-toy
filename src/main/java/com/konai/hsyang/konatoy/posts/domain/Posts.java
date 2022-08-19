package com.konai.hsyang.konatoy.posts.domain;

import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.dto.PostsUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postsID;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    private Long comment;
    private Long file;
    private Long loc;
    private String title;
    private String content;
    private Long hits = 0L;
    private Long likes = 0L;

    @Builder
    public Posts(User user, Long file, Long loc, String title, String content) {
        this.file = file;
        this.loc = loc;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void update(PostsUpdateRequestDto requestDto) {
        this.file = requestDto.getFileID();
        this.loc = requestDto.getLocID();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}

