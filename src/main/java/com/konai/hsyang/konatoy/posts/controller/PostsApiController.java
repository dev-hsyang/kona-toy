package com.konai.hsyang.konatoy.posts.controller;

import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.dto.*;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpEntity;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // C
//    @PostMapping("/api/posts")
//    public Long savePost(@RequestBody PostsSaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails) throws Exception{
//
//        postsService.setPostAuthor(requestDto, principalDetails.getId());
//        return postsService.save(requestDto);
//    }

    @PostMapping(value="/api/posts", consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody PostsSaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails){

        postsService.setPostAuthor(requestDto, principalDetails.getId());
        return new ResponseEntity<>(postsService.save(requestDto), HttpStatus.OK);
    }

    // R
    @GetMapping("/api/posts/{id}")
    public PostsResponseDto postFindById(@PathVariable Long id){

        return postsService.postsFindById(id);
    }

    // U
    @PostMapping("/api/posts/update/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){

        return postsService.update(id, requestDto);
    }

    // D
    @PostMapping("/api/posts/delete/{id}")
    public Long deletePost(@PathVariable Long id){

        return postsService.delete(id);
    }

    @PostMapping("/api/posts/view/addHit/{id}")
    public Long addHit(@PathVariable Long id){

        return postsService.updateHits(id);
    }

    @GetMapping("/api/posts/view-test")
    public PageImpl<Posts> getAll(CustomPageRequest customPageRequest) {

        return postsService.getPage(customPageRequest);
    }

    @GetMapping("/api/posts/view-test2")
    public PageImpl<Posts> getAll2(@RequestParam Integer page, Integer size) {

        return postsService.getPage2(page, size);
    }

    @GetMapping("/api/posts/view-test3")
    public Page<PostsListResponseDto> searchPosts(PageResponseDto responseDto, Pageable pageable){
        return postsService.getPage3(responseDto, pageable);
    }
}
