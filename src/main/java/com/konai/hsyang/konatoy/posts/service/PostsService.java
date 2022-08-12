package com.konai.hsyang.konatoy.posts.service;

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
        Long id =  postsRepository.save(requestDto.toEntity()).getId();
        return id;
    }

    public PostsResponseDto findById(Long id){
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
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository
                .findAllDesc()
                .stream()
                .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }
}