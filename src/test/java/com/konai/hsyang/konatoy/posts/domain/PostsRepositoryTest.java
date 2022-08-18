package com.konai.hsyang.konatoy.posts.domain;

import com.konai.hsyang.konatoy.posts.repository.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    private Long id;
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteById(id);
    }

    @Test
    public void 게시글_등록시간(){
        // given
        LocalDateTime now = LocalDateTime.of(2022, 7, 29, 0, 0, 0);

        postsRepository.save(Posts.builder()
                //.userID(1L)
                .title("title")
                .content("content")
                .loc(1L)
                .file(1L)
                .build()
        );

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        id = posts.getPostsID();

        System.out.println(">>>>>>>>>>created Date: " + posts.getCreatedate() + " modified Date: " + posts.getModifieddate());

//        assertThat(posts.getCreatedate()).isAfter(now);
//        assertThat(posts.getModifieddate()).isAfter(now);


    }
}
