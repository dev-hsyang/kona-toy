package com.konai.hsyang.konatoy.posts.repository;

import com.konai.hsyang.konatoy.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.postsID DESC")
    List<Posts> findAllDesc();

}
