package com.konai.hsyang.konatoy.posts.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.konai.hsyang.konatoy.posts.dto.QPostsListResponseDto is a Querydsl Projection type for PostsListResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPostsListResponseDto extends ConstructorExpression<PostsListResponseDto> {

    private static final long serialVersionUID = -1530523209L;

    public QPostsListResponseDto(com.querydsl.core.types.Expression<? extends com.konai.hsyang.konatoy.posts.domain.Posts> entity) {
        super(PostsListResponseDto.class, new Class<?>[]{com.konai.hsyang.konatoy.posts.domain.Posts.class}, entity);
    }

}

