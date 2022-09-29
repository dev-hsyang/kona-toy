package com.konai.hsyang.konatoy.posts.dto;

import com.konai.hsyang.konatoy.location.domain.Location;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private Long fileID;
    private Long locationID;
    private Location location;
    private String title;
    private String content;
    private double latitude;
    private double longtitude;

    @Builder
    public PostsUpdateRequestDto(Long fileID, Long locationID, String title, String content, double latitude, double longtitude) {
        this.fileID = fileID;
        this.locationID = locationID;
        this.title = title;
        this.content = content;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public void setLocation(Location location) {
        this.location = location; // 위치정보 수정에 대한 개발 필요
    }
}
