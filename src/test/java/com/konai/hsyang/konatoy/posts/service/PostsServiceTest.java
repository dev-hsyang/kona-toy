package com.konai.hsyang.konatoy.posts.service;

import com.konai.hsyang.konatoy.exceptions.NoPostsFoundException;
import com.konai.hsyang.konatoy.location.domain.Location;
import com.konai.hsyang.konatoy.location.repository.LocationRepository;
import com.konai.hsyang.konatoy.login.repository.UserRepository;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.dto.PostsSaveRequestDto;
import com.konai.hsyang.konatoy.posts.dto.PostsUpdateRequestDto;
import com.konai.hsyang.konatoy.posts.repository.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PostsServiceTest {

    @InjectMocks
    PostsService postsService;

    @Mock
    private PostsRepository postsRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private LocationRepository locationRepository;


    @DisplayName("Posts 등록")
    @Test
    void saveTest(){

        // given
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title("test title")
                .content("test content")
                .latitude(1.0)
                .longtitude(1.0)
                .build();

        Posts savePosts = requestDto.toEntity();
        ReflectionTestUtils.setField(savePosts, "postsID", 1L);

        given(postsRepository.save(any())).willReturn(savePosts); // BDD 패턴에 맞게 가독성 개선된 코드
        // when(postsRepository.save(any())).thenReturn(savePosts);
        given(postsRepository.findById(any())).willReturn(Optional.ofNullable(savePosts));
        // when(postsRepository.findById(any())).thenReturn(Optional.ofNullable(savePosts));

        // when
        requestDto.init();
        Long newPostsID = postsService.save(requestDto);

        // then
        System.out.println("저장된 제목 === " + postsService.findById(newPostsID).getTitle());
        System.out.println("저장된 본문 === " + postsService.findById(newPostsID).getContent());
        assertThat(requestDto.getTitle()).isEqualTo(postsService.findById(newPostsID).getTitle());
        assertThat(requestDto.getContent()).isEqualTo(postsService.findById(newPostsID).getContent());
//        AssertJ의 assertThat을 사용해야하는 이유는 메소드 자동완성,
//        assertThat에서 인자의 타입에 맞는 Assert클래스를 반환하기에 필요한 메소드만 분류되고,
//        체이닝 메소드 패턴으로 작성이 가능해 조건 추가를 위한 추가 작업이 필요없어 편리하고 가독성이 좋다
    }

    @DisplayName("Posts 수정")
    @Test
    void updateTest(){

        // given
        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .title("test title updated")
                .content("test content updated")
                .latitude(1.0)
                .longtitude(1.0)
                .build();

        Location location = new Location();
        Posts originPosts = Posts.builder()
                        .title("test title")
                        .content("test content")
                        .build();
        ReflectionTestUtils.setField(originPosts, "postsID", 1L);

        System.out.println("수정전 제목 === " + originPosts.getTitle());
        System.out.println("수정전 본문 === " + originPosts.getContent());

        given(locationRepository.findById(any())).willReturn(Optional.ofNullable(location));
        given(postsRepository.findById(any())).willReturn(Optional.ofNullable(originPosts));

        // when
        Long updatePostsID = postsService.update(1L, requestDto);

        // then
        System.out.println("수정된 제목 === " + postsRepository.findById(updatePostsID).orElseThrow(() -> new NoPostsFoundException()).getTitle());
        System.out.println("수정된 본문 === " + postsRepository.findById(updatePostsID).orElseThrow(() -> new NoPostsFoundException()).getContent());
        assertThat(requestDto.getTitle()).isEqualTo(postsRepository.findById(updatePostsID).orElseThrow(() -> new NoPostsFoundException()).getTitle());
        assertThat(requestDto.getContent()).isEqualTo(postsRepository.findById(updatePostsID).orElseThrow(() -> new NoPostsFoundException()).getContent());
    }

    @DisplayName("Posts 삭제")
    @Test
    void deleteTest(){

        // given

        // when

        // then


    }
}
