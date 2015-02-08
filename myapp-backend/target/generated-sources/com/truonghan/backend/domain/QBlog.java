package com.truonghan.backend.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBlog is a Querydsl query type for Blog
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBlog extends EntityPathBase<Blog> {

    private static final long serialVersionUID = -895584933L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBlog blog = new QBlog("blog");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ListPath<Item, QItem> items = this.<Item, QItem>createList("items", Item.class, QItem.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath url = createString("url");

    public final QUser user;

    public QBlog(String variable) {
        this(Blog.class, forVariable(variable), INITS);
    }

    public QBlog(Path<? extends Blog> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBlog(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBlog(PathMetadata<?> metadata, PathInits inits) {
        this(Blog.class, metadata, inits);
    }

    public QBlog(Class<? extends Blog> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

