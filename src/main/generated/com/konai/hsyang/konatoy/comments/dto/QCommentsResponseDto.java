package com.konai.hsyang.konatoy.comments.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.konai.hsyang.konatoy.comments.dto.QCommentsResponseDto is a Querydsl Projection type for CommentsResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCommentsResponseDto extends ConstructorExpression<CommentsResponseDto> {

    private static final long serialVersionUID = 1930178497L;

    public QCommentsResponseDto(com.querydsl.core.types.Expression<? extends com.konai.hsyang.konatoy.comments.domian.Comments> entity) {
        super(CommentsResponseDto.class, new Class<?>[]{com.konai.hsyang.konatoy.comments.domian.Comments.class}, entity);
    }

}

