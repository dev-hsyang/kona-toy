package com.konai.hsyang.konatoy.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private Long fileID;
    private Long locID;
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(Long fileID, Long locID, String title, String content) {
        this.fileID = fileID;
        this.locID = locID;
        this.title = title;
        this.content = content;
    }
}
