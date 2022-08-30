package com.konai.hsyang.konatoy.posts.repository;

import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import static com.konai.hsyang.konatoy.posts.domain.QPosts.posts;
import java.util.List;

@Repository
public class PostsCustomRepositoryImpl implements PostsCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    public PostsCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Posts> findAllDescCurrent() {
        return jpaQueryFactory.selectFrom(posts)
                .orderBy(posts.createdate.desc())
                .fetch();
    }

    @Override
    public List<Posts> findAllDescHits() {
        return jpaQueryFactory.selectFrom(posts)
                .orderBy(posts.hits.desc())
                .fetch();
    }

    @Override
    public List<Posts> findAllDescLikes() {
        return jpaQueryFactory.selectFrom(posts)
                .orderBy(posts.likes.desc())
                .fetch();
    }

    @Override
    public List<Posts> findAllDescByUser(Long userID) {
        return jpaQueryFactory.selectFrom(posts)
                .where(posts.user.userID.eq(userID))
                .orderBy(posts.createdate.desc())
                .fetch();
    }

    @Override
    public void updateHits(Long id) {
        jpaQueryFactory.update(posts)
                .set(posts.hits, posts.hits.add(1))
                .where(posts.postsID.eq(id))
                .execute();
    }

    @Override
    public void deleteAllByUser(Long id) {
        jpaQueryFactory.delete(posts)
                .where(posts.user.userID.eq(id))
                .execute();
    }
}
