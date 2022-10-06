package com.konai.hsyang.konatoy.posts.controller;

import com.konai.hsyang.konatoy.file.service.FileService;
import com.konai.hsyang.konatoy.location.dto.LocationSaveRequestDto;
import com.konai.hsyang.konatoy.location.service.LocationService;
import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.posts.dto.*;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    // RestFul API
    // URL은 자원을 표현하는데 집중하고 행위에 대한 정의는 HTTP METHOD를 통해 하는 것이 REST한 API 설계
    // /api/save X -> Post /api/posts O
    private final PostsService postsService;
    private final LocationService locationService;

    // C
//    @PostMapping("/api/posts")
//    public Long savePost(@RequestBody PostsSaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails) throws Exception{
//
//        postsService.setPostAuthor(requestDto, principalDetails.getId());
//        return postsService.save(requestDto);
//    }

    @PostMapping(value="/api/posts", consumes = "application/json")
    public Long save(@RequestBody PostsSaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails){

        postsService.setPostAuthor(requestDto, principalDetails.getId());
        postsService.setLocation(requestDto, locationService.save(new LocationSaveRequestDto(requestDto.getLatitude(), requestDto.getLongtitude())));
        return postsService.save(requestDto);
    }

    // R
    @GetMapping("/api/posts/{id}")
    public PostsResponseDto postFindById(@PathVariable Long id){

        return postsService.postsResponseDtoFindById(id);
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

//    @PostMapping("/api/posts/view/addHit/{id}")
//    public Long addHit(@PathVariable Long id){
//
//        return postsService.updateHits(id);
//    }

    @PostMapping("/api/posts/paging")
    public Page<PostsListResponseDto> page(@RequestBody PageRequestDto requestDto, @PageableDefault(size=15, sort="createdate") Pageable pageable){

        return postsService.getPage(requestDto, pageable);
    }

    @PostMapping("/api/posts/image")
    public PostsImageResponseDto image(@RequestParam("image") MultipartFile multi){

        return postsService.uploadImage(multi);
    }
}
