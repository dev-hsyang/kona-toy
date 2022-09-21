package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.location.domain.Location;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private Long fileID;
    private Location location;
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(Long fileID, Location location, String title, String content) {
        this.fileID = fileID;
        this.location = location;
        this.title = title;
        this.content = content;
    }
}
