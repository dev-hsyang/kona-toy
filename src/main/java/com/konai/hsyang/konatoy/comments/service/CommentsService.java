package com.konai.hsyang.konatoy.comments.service;

import com.konai.hsyang.konatoy.comments.dto.CommentsResponseDto;
import com.konai.hsyang.konatoy.comments.dto.CommentsSaveRequestDto;
import com.konai.hsyang.konatoy.comments.dto.CommentsUpdateRequestDto;
import com.konai.hsyang.konatoy.comments.repository.CommentsRepository;
import com.konai.hsyang.konatoy.exceptions.NoCommentFoundException;
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

        User user = userService.findByUsername(username);
        Posts post = postsService.findById(postID);
        requestDto.setCommentInfo(user, post);
        commentsRepository.save(requestDto.toEntity());
        return requestDto.getCommentsID();
    }

    public List<CommentsResponseDto> findAllByUserId(Long userID) {

        return commentsRepository.findAllbyUserId(userID);
    }

    public List<CommentsResponseDto> findAllByPostId(Long postId) {

        return commentsRepository.findAllByPostId(postId);
    }

    public List<CommentsResponseDto> getCommentsList(String nickname, Long postID) {

        List<CommentsResponseDto> list = this.commentsFindByPost(postID);
        for(CommentsResponseDto dto : list) {
            dto.setFlag(nickname.equals(dto.getNickname()) ? true : false);
        }
        return list;
    }

    @Transactional
    public Long delete(Long id){

        commentsRepository.delete(commentsRepository.findById(id).orElseThrow(()-> new NoCommentFoundException()));
        return id;
    }

    @Transactional
    public Long update(Long commentID, CommentsUpdateRequestDto requestDto) {

        commentsRepository.findById(commentID).orElseThrow(() -> new NoCommentFoundException()).update(requestDto);
        return commentID;
    }

    public Long getPostID(Long commentID){

        return commentsRepository.findById(commentID).orElseThrow(()-> new NoCommentFoundException()).getPost().getPostsID();
    }

//    public ArrayList<Boolean> isCommentWriter(String nickname, List<CommentsResponseDto> commentsList) {
//
//        ArrayList<Boolean> isWriter = new ArrayList<Boolean>();
//        for(CommentsResponseDto dto : commentsList) {
//            isWriter.add(nickname.equals(dto.getNickname()) ? true : false);
//        }
//        return isWriter;
//    }
}
