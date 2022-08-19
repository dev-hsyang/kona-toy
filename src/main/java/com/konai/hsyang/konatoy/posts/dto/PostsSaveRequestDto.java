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

    @Builder
    public PostsSaveRequestDto(String title, String content, Long locID, Long fileID) {
        this.title = title;
        this.content = content;
        this.locID = locID;
        this.fileID = fileID;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .loc(locID)
                .file(fileID)
                .user(author)
                .build();
    }

    public void setAuthor(User user){
        this.author = user;
    }
}


