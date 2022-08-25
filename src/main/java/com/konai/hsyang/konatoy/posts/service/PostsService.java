package com.konai.hsyang.konatoy.posts.service;

import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.dto.PostsListResponseDto;
import com.konai.hsyang.konatoy.posts.dto.PostsResponseDto;
import com.konai.hsyang.konatoy.posts.dto.PostsSaveRequestDto;
import com.konai.hsyang.konatoy.posts.dto.PostsUpdateRequestDto;
import com.konai.hsyang.konatoy.posts.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        requestDto.init();
        Long id =  postsRepository.save(requestDto.toEntity()).getPostsID();
        return id;
    }

    public PostsResponseDto postsFindById(Long id){
        Posts post = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Such Posting."));

        return new PostsResponseDto(post);
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts post = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No Such Posting."));

        post.update(requestDto);

        return id;
    }

    @Transactional
    public void delete(Long id){
        Posts post = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No Such Posting."));
        postsRepository.delete(post);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDescCurrent(){
        return postsRepository
                .findAllDescCurrent()
                .stream()
                .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PostsListResponseDto> findAllDescHits(){
        return postsRepository
                .findAllDescHits()
                .stream()
                .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PostsListResponseDto> findAllDescLikes(){
        return postsRepository
                .findAllDescLikes()
                .stream()
                .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PostsListResponseDto> findAllDescById(Long userID){
        return postsRepository
                .findAllDescByUser(userID)
                .stream()
                .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public void addHits(Long id){
        postsRepository.addHit(id);
    }

}