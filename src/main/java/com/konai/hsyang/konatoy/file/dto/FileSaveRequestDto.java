package com.konai.hsyang.konatoy.file.dto;

import com.konai.hsyang.konatoy.file.domain.File;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FileSaveRequestDto {

    private Posts posts;
    private String orgFileName;
    private String saveFileName;
    private String storePath;
    private Long fileSize;

    @Builder
    public FileSaveRequestDto(Posts posts, String orgFileName, String saveFileName, String storePath, Long fileSize){
        this.posts = posts;
        this.orgFileName = orgFileName;
        this.saveFileName = saveFileName;
        this.storePath = storePath;
        this.fileSize = fileSize;
    }

    public File toEntity(){
        return File.builder()
                .posts(posts)
                .orgFileName(orgFileName)
                .saveFileName(saveFileName)
                .storePath(storePath)
                .fileSize(fileSize)
                .build();
    }
}
