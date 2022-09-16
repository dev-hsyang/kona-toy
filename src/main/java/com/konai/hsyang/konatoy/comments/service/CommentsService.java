package com.konai.hsyang.konatoy.comments.service;

import com.konai.hsyang.konatoy.comments.dto.CommentsResponseDto;
import com.konai.hsyang.konatoy.comments.dto.CommentsSaveRequestDto;
import com.konai.hsyang.konatoy.comments.repository.CommentsRepository;
import com.konai.hsyang.konatoy.exceptions.NoPostsFoundException;
import com.konai.hsyang.konatoy.exceptions.NoUserFoundException;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.login.service.UserService;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final PostsService postsService;
    private final UserService userService;

    public List<CommentsResponseDto> commentsFindByPost(Long postID){

        List<CommentsResponseDto> comments = postsService.postsResponseDtoFindById(postID).getComments();
        return comments;
    }

    @Transactional
    public Long saveComment(String username, Long postID, CommentsSaveRequestDto requestDto){

        User user = userService.findByUsername(username).orElseThrow(()-> new NoUserFoundException());
        Posts post = postsService.findById(postID).orElseThrow(()-> new NoPostsFoundException());
        requestDto.setCommentInfo(user, post);
        commentsRepository.save(requestDto.toEntity());
        return requestDto.getCommentsID();
    }

    public List<CommentsResponseDto> findAllByUserId(Long userID) {

        return commentsRepository.findAllbyUserId(userID);
    }

    public CommentsResponseDto findByPostId(Long postId) {

        return commentsRepository.findByPostId(postId);
    }

    public boolean isCommentWriter(String nickname, CommentsResponseDto responseDto) {
        return nickname.equals(responseDto.getNickname()) ? true : false;
    }



}
