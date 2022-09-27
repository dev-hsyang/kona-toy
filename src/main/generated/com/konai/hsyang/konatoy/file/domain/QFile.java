package com.konai.hsyang.konatoy.file.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFile is a Querydsl query type for File
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFile extends EntityPathBase<File> {

    private static final long serialVersionUID = 471498804L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFile file = new QFile("file");

    public final com.konai.hsyang.konatoy.posts.etc.QBaseTimeEntity _super = new com.konai.hsyang.konatoy.posts.etc.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdate = _super.createdate;

    public final NumberPath<Long> fileID = createNumber("fileID", Long.class);

    public final NumberPath<Long> fileSize = createNumber("fileSize", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifieddate = _super.modifieddate;

    public final StringPath orgFileName = createString("orgFileName");

    public final com.konai.hsyang.konatoy.posts.domain.QPosts posts;

    public final StringPath saveFileName = createString("saveFileName");

    public final StringPath storePath = createString("storePath");

    public QFile(String variable) {
        this(File.class, forVariable(variable), INITS);
    }

    public QFile(Path<? extends File> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFile(PathMetadata metadata, PathInits inits) {
        this(File.class, metadata, inits);
    }

    public QFile(Class<? extends File> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.posts = inits.isInitialized("posts") ? new com.konai.hsyang.konatoy.posts.domain.QPosts(forProperty("posts"), inits.get("posts")) : null;
    }

}

