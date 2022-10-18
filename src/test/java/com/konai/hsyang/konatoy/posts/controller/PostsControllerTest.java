package com.konai.hsyang.konatoy.posts.controller;


import com.konai.hsyang.konatoy.comments.service.CommentsService;
import com.konai.hsyang.konatoy.location.service.LocationService;
import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetailsService;
import com.konai.hsyang.konatoy.login.config.auth.SessionUser;
import com.konai.hsyang.konatoy.login.domain.Club;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.login.etc.Role;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.dto.PostsResponseDto;
import com.konai.hsyang.konatoy.posts.dto.PostsSaveRequestDto;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.test.context.support.TestExecutionEvent;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PostsController.class})
@WebAppConfiguration
@AutoConfigureMockMvc
public class PostsControllerTest {

    // PostsController에서 잡고 있는 Bean 객체에 대해 Mock 형태의 객체를 생성
    @MockBean
    PostsService postsService;

    @MockBean
    CommentsService commentsService;

    @MockBean
    LocationService locationService;

    @Autowired
    private MockMvc mockMvc;

//    @BeforeEach
//    void init(){
//        PrincipalDetails principalDetails = createPrincipalDetails();
//
//        SecurityContext context = SecurityContextHolder.getContext();
//        context.setAuthentication(new UsernamePasswordAuthenticationToken(principalDetails, principalDetails.getPassword(), principalDetails.getAuthorities()));
//    }
//
//    private PrincipalDetails createPrincipalDetails(){
//        return new PrincipalDetails(new SessionUser(User.builder()
//                .userID(1L)
//                .userName("testName")
//                .userPw("testPassword")
//                .club(Club.builder()
//                        .clubname("testClub")
//                        .build())
//                .role(Role.USER)
//                .build()));
//    }

    @DisplayName("Post 저장하기 테스트")
    @Test
    void savePostTest() throws Exception {

        mockMvc.perform(get("/posts/save"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(forwardedUrl("posts-saveV2"));
    }

    @DisplayName("Post 조회 테스트")
    //@WithUserDetails(value = "testName", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @Test
    void viewPostTest() throws Exception {

        PostsResponseDto responseDto = PostsResponseDto.builder()
                .title("test title")
                .content("test content")
                .build();

        given(postsService.postsResponseDtoFindById(any())).willReturn(responseDto);

        mockMvc.perform(get("/posts/view/1"))
                .andExpect(model().attributeExists("post"))
                .andExpect(forwardedUrl("posts-view"))
                .andExpect(status().isOk())
                .andDo(print());

        // given: Mock 객체가 특정 상황에서 해야하는 행위를 정의
    }
}
