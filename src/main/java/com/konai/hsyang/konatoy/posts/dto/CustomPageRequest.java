package com.konai.hsyang.konatoy.posts.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.*;

public class CustomPageRequest {

    private int page = 1;
    private int size = 15;
    private Sort.Direction direction = Sort.Direction.DESC;

    public CustomPageRequest(){

    }
    @Builder
    public CustomPageRequest(Integer page, Integer size){
        this.page = page;
        this.size = size;
    }

    public void setPage(int page){

        this.page = page <= 0 ? 1 : page;
    }

    public void setSize(int size){

        int DEFAULT_SIZE = 15;
        int MAX_SIZE = 50;
        this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
    }

    public void setDirection(Sort.Direction direction){

        this.direction = direction;
    }

    public PageRequest of() {

        return PageRequest.of(page-1, size, direction, "createdate");
    }

}
