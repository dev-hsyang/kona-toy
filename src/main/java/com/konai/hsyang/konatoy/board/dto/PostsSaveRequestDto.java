package com.konai.hsyang.konatoy.board.dto;

import com.konai.hsyang.konatoy.board.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private Long userID;
    private String title;
    private String content;
    private Long locID;
    private Long fileID;

    @Builder
    public PostsSaveRequestDto(Long userID, String title, String content, Long locID, Long fileID) {
        this.userID = userID;
        this.title = title;
        this.content = content;
        this.locID = locID;
        this.fileID = fileID;
    }

    public Posts toEntity(){
        return Posts.builder()
                .userID(userID)
                .title(title)
                .content(content)
                .locID(locID)
                .fileID(fileID)
                .build();
    }
}
