package com.konai.hsyang.konatoy.comments.repository;

import com.konai.hsyang.konatoy.comments.domian.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
