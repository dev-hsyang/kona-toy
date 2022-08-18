package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.login.repository.UserRepository;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

@Getter
@NoArgsConstructor
//@RequiredArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private User userID;
    private Long locID;
    private Long fileID;
    private Long clubID;


    @Builder
    public PostsSaveRequestDto(String title, String content, Long locID, Long fileID, Long clubID) {
        this.title = title;
        this.content = content;
        this.locID = locID;
        this.fileID = fileID;
        this.clubID = clubID;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .loc(locID)
                .file(fileID)
                .file(clubID)
                .user(userID)
                .build();
    }

    public void setPostsUserID(User user){
        this.userID = user;
    }
}


