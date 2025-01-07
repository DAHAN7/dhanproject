package com.shop.entity;

import java.math.BigDecimal;

import javax.annotation.processing.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.PathMetadataFactory;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.shop.constant.ItemSellStatus;
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = 1L;

    public static final QItem item = new QItem("item");

    public final StringPath itemDetail = createString("itemDetail");
    public final EnumPath<ItemSellStatus> itemSellStatus = createEnum("itemSellStatus", ItemSellStatus.class);
    public final NumberPath<BigDecimal> price = createNumber("price", BigDecimal.class);
    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QItem(String variable) {
        super(Item.class, PathMetadataFactory.forVariable(variable));
    }

    public QItem(Path<? extends Item> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItem(PathMetadata metadata) {
        super(Item.class, metadata);
    }
}
