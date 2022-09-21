package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.location.domain.Location;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
//@RequiredArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private Location location;
    private User author;
    private String content;
    private Long fileID;
    private Long hits;
    private Long likes;
    private Long latitude;
    private Long longtitude;

    @Builder
    public PostsSaveRequestDto(String title, String content, Long fileID, Long hits, Long likes, Long latitude, Long longtitude) {
        this.title = title;
        this.content = content;
        this.fileID = fileID;
        this.hits = hits;
        this.likes = likes;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .location(location)
                .file(fileID)
                .user(author)
                .hits(hits)
                .likes(likes)
                .build();
    }

    public void setAuthor(User user){

        this.author = user;
    }

    public void setLocation(Location location){

        this.location = location;
    }
    public void init() {

        this.likes = 0L;
        this.hits = 0L;
    }
}


