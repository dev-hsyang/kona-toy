package com.konai.hsyang.konatoy.comments.repository;

import com.konai.hsyang.konatoy.comments.dto.CommentsResponseDto;
import com.konai.hsyang.konatoy.comments.dto.QCommentsResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.konai.hsyang.konatoy.comments.domian.QComments.comments;

@Repository
public class CommentsCustomRepositoryImpl implements CommentsCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public CommentsCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<CommentsResponseDto> findAllbyUserId(Long userId) {
        return jpaQueryFactory
                .select(new QCommentsResponseDto(comments))
                .from(comments)
                .where(comments.user.userID.eq(userId))
                .orderBy(comments.createdate.desc())
                .fetch();
    }

    @Override
    public List<CommentsResponseDto> findAllByPostId(Long postId) {
        return jpaQueryFactory
                .select(new QCommentsResponseDto(comments))
                .from(comments)
                .where(comments.post.postsID.eq(postId))
                .orderBy(comments.createdate.asc())
                .fetch();
    }
}
