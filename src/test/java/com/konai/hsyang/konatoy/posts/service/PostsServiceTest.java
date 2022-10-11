package com.konai.hsyang.konatoy.posts.service;

import com.konai.hsyang.konatoy.exceptions.NoPostsFoundException;
import com.konai.hsyang.konatoy.location.repository.LocationRepository;
import com.konai.hsyang.konatoy.login.repository.UserRepository;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.dto.PostsSaveRequestDto;
import com.konai.hsyang.konatoy.posts.repository.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static reactor.core.publisher.Mono.when;

@ExtendWith(SpringExtension.class)
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

    @Test
    void saveTest(){

        // given
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title("test title")
                .content("test content")
                .latitude(1.0)
                .longtitude(1.0)
                .build();


        // when
        requestDto.init();
        String savedTitle = postsRepository

        // then
        Assertions.assertThat()






    }
}
