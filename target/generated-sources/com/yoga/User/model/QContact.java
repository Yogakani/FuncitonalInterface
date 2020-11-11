package com.yoga.User.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QContact is a Querydsl query type for Contact
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContact extends EntityPathBase<Contact> {

    private static final long serialVersionUID = 311711817L;

    public static final QContact contact = new QContact("contact");

    public final QMaster _super = new QMaster(this);

    public final StringPath address = createString("address");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Long> editedBy = _super.editedBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> modifiedDate = _super.modifiedDate;

    public final NumberPath<Long> zipCode = createNumber("zipCode", Long.class);

    public QContact(String variable) {
        super(Contact.class, forVariable(variable));
    }

    public QContact(Path<? extends Contact> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContact(PathMetadata metadata) {
        super(Contact.class, metadata);
    }

}

