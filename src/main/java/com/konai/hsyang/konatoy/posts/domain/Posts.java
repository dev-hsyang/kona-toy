package com.konai.hsyang.konatoy.posts.domain;

import com.konai.hsyang.konatoy.comments.domian.Comments;
import com.konai.hsyang.konatoy.file.domain.File;
import com.konai.hsyang.konatoy.location.domain.Location;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.dto.PostsUpdateRequestDto;
import com.konai.hsyang.konatoy.posts.etc.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @OneToOne
    @JoinColumn(name = "location")
    private Location location;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Comments> comments;

    @OneToMany(mappedBy = "posts", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<File> file;

    private String title;
    private String content;
    private Long hits;
    private Long likes;

    @Builder
    public Posts(User user, Location location, String title, String content, Long hits, Long likes) {
        this.location = location;
        this.title = title;
        this.content = content;
        this.user = user;
        this.hits = hits;
        this.likes = likes;
    }

    public void update(PostsUpdateRequestDto requestDto) {
        this.location = requestDto.getLocation();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}

