package com.konai.hsyang.konatoy.file.domain;

import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.etc.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class File extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileID;

    @ManyToOne
    @JoinColumn(name = "posts")
    private Posts posts;

    private String orgfilename;
    private String savefilename;
    private String storepath;
    private Long filesize;

    @Builder
    public File(Posts posts, String orgFileName, String saveFileName, String storePath, Long fileSize) {
        this.posts = posts;
        this.orgfilename = orgFileName;
        this.savefilename = saveFileName;
        this.storepath = storePath;
        this.filesize = fileSize;
    }
}
