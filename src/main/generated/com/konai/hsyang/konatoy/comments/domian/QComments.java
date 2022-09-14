package com.konai.hsyang.konatoy.comments.domian;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComments is a Querydsl query type for Comments
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComments extends EntityPathBase<Comments> {

    private static final long serialVersionUID = 703482388L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComments comments = new QComments("comments");

    public final com.konai.hsyang.konatoy.posts.etc.QBaseTimeEntity _super = new com.konai.hsyang.konatoy.posts.etc.QBaseTimeEntity(this);

    public final NumberPath<Long> commentsID = createNumber("commentsID", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdate = _super.createdate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifieddate = _super.modifieddate;

    public final com.konai.hsyang.konatoy.posts.domain.QPosts post;

    public final com.konai.hsyang.konatoy.login.domain.QUser user;

    public QComments(String variable) {
        this(Comments.class, forVariable(variable), INITS);
    }

    public QComments(Path<? extends Comments> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComments(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComments(PathMetadata metadata, PathInits inits) {
        this(Comments.class, metadata, inits);
    }

    public QComments(Class<? extends Comments> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new com.konai.hsyang.konatoy.posts.domain.QPosts(forProperty("post"), inits.get("post")) : null;
        this.user = inits.isInitialized("user") ? new com.konai.hsyang.konatoy.login.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

