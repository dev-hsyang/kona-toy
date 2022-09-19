package com.konai.hsyang.konatoy.comments.dto;

import com.konai.hsyang.konatoy.comments.domian.Comments;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentsUpdateRequestDto {

    private Long commentsID;
    private String content;
    private LocalDateTime createdate;
    private LocalDateTime modifieddate;

    public Comments toEntity() {
        return Comments.builder()
                .content(content)
                .build();
    }
}
