package com.konai.hsyang.konatoy.posts.service;

import com.konai.hsyang.konatoy.exceptions.NoPostsFoundException;
import com.konai.hsyang.konatoy.location.repository.LocationRepository;
import com.konai.hsyang.konatoy.login.repository.UserRepository;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.dto.PostsSaveRequestDto;
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

    @Test
    void deleteTest(){


    }

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

        // given(postsRepository.save(any())).willReturn(savePosts); // BDD 패턴에 맞게 가독성 개선된 코드
        when(postsRepository.save(any())).thenReturn(savePosts);
        when(postsRepository.findById(any())).thenReturn(Optional.ofNullable(savePosts));

        // when
        requestDto.init();
        Long newPostsID = postsService.save(requestDto);

        // then
        System.out.println("저장된 제목 === " + postsService.findById(newPostsID).getTitle());
        System.out.println("저장된 본문 === " + postsService.findById(newPostsID).getContent());
        Assertions.assertThat(requestDto.getTitle()).isEqualTo(postsService.findById(newPostsID).getTitle());
        Assertions.assertThat(requestDto.getContent()).isEqualTo(postsService.findById(newPostsID).getContent());
    }
}
