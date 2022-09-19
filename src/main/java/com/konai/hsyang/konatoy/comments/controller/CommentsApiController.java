package com.konai.hsyang.konatoy.comments.controller;

import com.konai.hsyang.konatoy.comments.dto.CommentsSaveRequestDto;
import com.konai.hsyang.konatoy.comments.dto.CommentsUpdateRequestDto;
import com.konai.hsyang.konatoy.comments.service.CommentsService;
import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentsApiController {

    private final CommentsService commentsService;

    @PostMapping("/api/comments/save/{postID}")
    public ResponseEntity<?> saveComment(@PathVariable Long postID, @RequestBody CommentsSaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails){

        return ResponseEntity.ok(commentsService.saveComment(principalDetails.getUsername(), postID, requestDto));
    }

    @PostMapping("/api/comments/delete/{commentID}")
    public Long deleteComment(@PathVariable Long commentID) {

        return commentsService.delete(commentID);
    }

    @PostMapping("/api/comments/update/{commentID}")
    public Long updateComment(@PathVariable Long commentID, @RequestBody CommentsUpdateRequestDto requestDto) {

        return commentsService.update(commentID, requestDto);
    }

}
