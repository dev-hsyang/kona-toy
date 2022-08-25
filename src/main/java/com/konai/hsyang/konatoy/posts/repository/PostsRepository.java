package com.konai.hsyang.konatoy.posts.repository;

import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.postsID DESC")
    List<Posts> findAllDescCurrent();

    @Query("SELECT p FROM Posts p ORDER BY p.hits DESC")
    List<Posts> findAllDescHits();

    @Query("SELECT p FROM Posts p ORDER BY p.likes DESC")
    List<Posts> findAllDescLikes();

    @Query("SELECT p FROM Posts p WHERE p.user.userID = :userID")
    List<Posts> findAllDescByUser(@Param("userID") Long userID);

    @Modifying
    @Query("UPDATE Posts p SET p.hits = p.hits+1 WHERE p.postsID = :id")
    void addHit(@Param("id") Long id);
}
