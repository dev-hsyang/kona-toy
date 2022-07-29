package com.konai.hsyang.konatoy.board.service;

import com.konai.hsyang.konatoy.board.dto.PostsSaveRequestDto;
import com.konai.hsyang.konatoy.board.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        Long id =  postsRepository.save(requestDto.toEntity()).getId();
        return id;
    }

}
