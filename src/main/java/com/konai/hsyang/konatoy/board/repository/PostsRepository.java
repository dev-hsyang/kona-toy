package com.konai.hsyang.konatoy.board.repository;

import com.konai.hsyang.konatoy.board.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
