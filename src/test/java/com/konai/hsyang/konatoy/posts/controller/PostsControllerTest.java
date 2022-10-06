package com.konai.hsyang.konatoy.posts.controller;


import com.konai.hsyang.konatoy.comments.service.CommentsService;
import com.konai.hsyang.konatoy.location.service.LocationService;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(PostsController.class) // test하고자 하는 class를 인자로 넣어준다
public class PostsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Controller에서 잡고 있는 Bean 객체에 대해 Mock 형태의 객체를 생성
    @MockBean
    PostsService postsService;

    @MockBean
    CommentsService commentsService;

    @MockBean
    LocationService locationService;

    @Test
    @DisplayName("Post 저장하기 테스트")
    void savePostTest() throws Exception {

    }

    @Test
    @DisplayName("Post 조회 테스트")
    void viewPostTest() throws Exception {

        // given: Mock 객체가 특정 상황에서 해야하는 행위를 정의
    }



}
