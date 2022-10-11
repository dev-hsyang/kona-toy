package com.konai.hsyang.konatoy.posts.controller;


import com.konai.hsyang.konatoy.comments.service.CommentsService;
import com.konai.hsyang.konatoy.location.service.LocationService;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
// @WebMvcTest(PostsController.class) // test하고자 하는 class를 인자로 넣어준다
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsControllerTest {

    @Autowired
    private WebApplicationContext context;

    // PostsController에서 잡고 있는 Bean 객체에 대해 Mock 형태의 객체를 생성
    @Autowired
    PostsService postsService;

    @Autowired
    CommentsService commentsService;

    @Autowired
    LocationService locationService;

    private MockMvc mockMvc;
    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @DisplayName("Post 저장하기 테스트")
    @WithMockUser(roles="USER")
    @Test
    void savePostTest() throws Exception {
        mockMvc.perform(get("/posts/save"))
                .andExpect(status().isOk())
                .andExpect(content().string("posts-saveV2"));
    }

    @Test
    @DisplayName("Post 조회 테스트")
    void viewPostTest() throws Exception {

        // given: Mock 객체가 특정 상황에서 해야하는 행위를 정의
    }
}
