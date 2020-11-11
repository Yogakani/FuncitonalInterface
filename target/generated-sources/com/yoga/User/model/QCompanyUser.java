package com.yoga.User.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompanyUser is a Querydsl query type for CompanyUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompanyUser extends EntityPathBase<CompanyUser> {

    private static final long serialVersionUID = 1679297937L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompanyUser companyUser = new QCompanyUser("companyUser");

    public final QMaster _super = new QMaster(this);

    public final QCompany company;

    public final NumberPath<Long> companyId = createNumber("companyId", Long.class);

    public final QContact contact;

    public final NumberPath<Long> contactId = createNumber("contactId", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Long> editedBy = _super.editedBy;

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    //inherited
    public final DateTimePath<java.util.Date> modifiedDate = _super.modifiedDate;

    public final StringPath password = createString("password");

    public final QRole role;

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final StringPath userId = createString("userId");

    public QCompanyUser(String variable) {
        this(CompanyUser.class, forVariable(variable), INITS);
    }

    public QCompanyUser(Path<? extends CompanyUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompanyUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompanyUser(PathMetadata metadata, PathInits inits) {
        this(CompanyUser.class, metadata, inits);
    }

    public QCompanyUser(Class<? extends CompanyUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company"), inits.get("company")) : null;
        this.contact = inits.isInitialized("contact") ? new QContact(forProperty("contact")) : null;
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role")) : null;
    }

}

