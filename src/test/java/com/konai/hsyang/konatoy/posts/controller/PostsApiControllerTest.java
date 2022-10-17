package com.konai.hsyang.konatoy.posts.controller;

import com.konai.hsyang.konatoy.location.service.LocationService;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PostsApiController.class})
@WebAppConfiguration
@AutoConfigureMockMvc
public class PostsApiControllerTest {

    @Mock
    private PostsService postsService;

    @Mock
    private LocationService locationService;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Posts 저장 API 테스트")
    @WithUserDetails
    @Test
    void saveTest(){

    }
}
