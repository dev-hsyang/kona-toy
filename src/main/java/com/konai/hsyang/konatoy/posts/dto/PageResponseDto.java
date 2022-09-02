package com.konai.hsyang.konatoy.posts.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PageResponseDto {

    String page;
    String size;
    String sort;

    @Builder
    PageResponseDto(String page, String size, String sort){
        this.page = page;
        this.size = size;
        this.sort = sort;
    }
}
