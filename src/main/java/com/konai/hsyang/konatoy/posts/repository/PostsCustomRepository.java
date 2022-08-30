package com.konai.hsyang.konatoy.posts.repository;

import com.konai.hsyang.konatoy.posts.domain.Posts;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsCustomRepository {

    List<Posts> findAllDescCurrent();
    List<Posts> findAllDescHits();
    List<Posts> findAllDescLikes();
    List<Posts> findAllDescByUser(@Param("userID") Long userID);
    void updateHits(@Param("id") Long id);
    void deleteAllByUser(@Param("userID") Long id);
}
