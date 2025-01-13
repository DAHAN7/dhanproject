package com.shop.entity;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.shop.constant.ItemSellStatus;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = 1L;

    public static final QItem item = new QItem("item");

    public final StringPath itemNm = createString("itemNm");
    public final NumberPath<Integer> price = createNumber("price", Integer.class);
    public final StringPath itemDetail = createString("itemDetail");
    public final EnumPath<ItemSellStatus> itemSellStatus = createEnum("itemSellStatus", ItemSellStatus.class);
    public final NumberPath<Integer> stockNumber = createNumber("stockNumber", Integer.class);
    public final DateTimePath<LocalDateTime> regTime = createDateTime("regTime", LocalDateTime.class);
    public final DateTimePath<LocalDateTime> updateTime = createDateTime("updateTime", LocalDateTime.class);

    public QItem(String variable) {
        super(Item.class, forVariable(variable));
    }

    private static String forVariable(String variable) {
		return null;
	}

	public QItem(Path<? extends Item> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItem(PathMetadata metadata) {
        super(Item.class, metadata);
    }
}
