package com.konai.hsyang.konatoy.posts.repository;

import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.dto.PageResponseDto;
import com.konai.hsyang.konatoy.posts.dto.PostsListResponseDto;
import com.konai.hsyang.konatoy.posts.dto.QPostsListResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
        return jpaQueryFactory
                .selectFrom(posts)
                .orderBy(posts.createdate.desc())
                .fetch();
    }

    @Override
    public List<Posts> findAllDescHits() {
        return jpaQueryFactory
                .selectFrom(posts)
                .orderBy(posts.hits.desc())
                .fetch();
    }

    @Override
    public List<Posts> findAllDescLikes() {
        return jpaQueryFactory
                .selectFrom(posts)
                .orderBy(posts.likes.desc())
                .fetch();
    }

    @Override
    public List<Posts> findAllDescByUser(Long userID) {
        return jpaQueryFactory
                .selectFrom(posts)
                .where(posts.user.userID.eq(userID))
                .orderBy(posts.createdate.desc())
                .fetch();
    }

    @Override
    public void updateHits(Long id) {
        jpaQueryFactory
                .update(posts)
                .set(posts.hits, posts.hits.add(1))
                .where(posts.postsID.eq(id))
                .execute();
    }

    @Override
    public void deleteAllByUser(Long id) {
        jpaQueryFactory
                .delete(posts)
                .where(posts.user.userID.eq(id))
                .execute();
    }

    @Override
    public PageImpl<Posts> findAllV1(Pageable pageable) {
        List<Posts> postsList = jpaQueryFactory
                .selectFrom(posts)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(posts.createdate.desc()) // 추후 동적으로 작동하게 수정
                .fetch();

        return new PageImpl<>(postsList, pageable, postsList.size());
    }



    @Override
    public Page<PostsListResponseDto> findAllV2(PageResponseDto responseDto, Pageable pageable){

        List<PostsListResponseDto> content = getPostsList(responseDto, pageable);
        Long count = getCount(responseDto);
        return new PageImpl<>(content, pageable, count);
    }

    private Long getCount(PageResponseDto responseDto){

        Long count = jpaQueryFactory
                .select(posts.count())
                .from(posts)
                .fetchOne();
        return count;
    }

    private List<PostsListResponseDto> getPostsList(PageResponseDto responseDto, Pageable pageable){

        List<PostsListResponseDto> content = jpaQueryFactory
                .select(new QPostsListResponseDto(posts))
                .from(posts)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(posts.createdate.desc())
                .fetch();
        return content;
    }
}
