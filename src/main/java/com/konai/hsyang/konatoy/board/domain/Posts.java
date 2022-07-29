package com.konai.hsyang.konatoy.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userID;
    private Long commentID;
    private Long fileID;
    private Long locID;
    private String title;
    private String content;
    private Long hits = 0L;
    private Long likes = 0L;

    @Builder
    public Posts(Long userID, Long fileID, Long locID, String title, String content){
        this.fileID = fileID;
        this.locID = locID;
        this.title = title;
        this.content = content;
        this.userID = userID;
    }

    public void update(String title, String content, Long file, Long loc){
        this.title = title;
        this.content = content;
        this.fileID = file;
        this.locID = loc;
    }


}

