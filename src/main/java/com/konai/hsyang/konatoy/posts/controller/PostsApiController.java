package com.konai.hsyang.konatoy.posts.controller;

import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.login.repository.UserRepository;
import com.konai.hsyang.konatoy.posts.dto.PostsResponseDto;
import com.konai.hsyang.konatoy.posts.dto.PostsSaveRequestDto;
import com.konai.hsyang.konatoy.posts.dto.PostsUpdateRequestDto;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    private final UserRepository userRepository;

    // C
    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails) throws Exception{
        requestDto.setAuthor(userRepository.findById(principalDetails.getId()).orElseThrow(() -> new Exception("작성자를 찾을 수 없습니다.")));

        return postsService.save(requestDto);
    }

    // R
    @GetMapping("/api/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.postsFindById(id);
    }

    // U
    @PutMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    // D
    @DeleteMapping("/api/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
