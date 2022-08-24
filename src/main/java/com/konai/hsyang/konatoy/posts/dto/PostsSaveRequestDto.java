package com.konai.hsyang.konatoy.posts.dto;

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
    private String content;
    private User author;
    private Long locID;
    private Long fileID;
    private Long hits;
    private Long likes;

    @Builder
    public PostsSaveRequestDto(String title, String content, Long locID, Long fileID, Long hits, Long likes) {
        this.title = title;
        this.content = content;
        this.locID = locID;
        this.fileID = fileID;
        this.hits = hits;
        this.likes = likes;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .loc(locID)
                .file(fileID)
                .user(author)
                .hits(hits)
                .likes(likes)
                .build();
    }

    public void setAuthor(User user){
        this.author = user;
    }

    public void init(){
        this.likes = 0L;
        this.hits = 1L;
    }
}


