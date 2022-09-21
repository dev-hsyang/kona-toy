package com.konai.hsyang.konatoy.posts.domain;

import com.konai.hsyang.konatoy.comments.domian.Comments;
import com.konai.hsyang.konatoy.location.domain.Location;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.dto.PostsUpdateRequestDto;
import com.konai.hsyang.konatoy.posts.etc.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Comments> comments;

    @OneToOne
    @JoinColumn(name = "location")
    private Location location;
    private Long file;
    private String title;
    private String content;
    private Long hits;
    private Long likes;

    @Builder
    public Posts(User user, Long file, Location location, String title, String content, Long hits, Long likes) {
        this.file = file;
        this.location = location;
        this.title = title;
        this.content = content;
        this.user = user;
        this.hits = hits;
        this.likes = likes;
    }

    public void update(PostsUpdateRequestDto requestDto) {
        this.file = requestDto.getFileID();
        this.location = requestDto.getLocation();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}

