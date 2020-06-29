package com.yoga.User.repositories;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yoga.User.model.CompanyUser;
import com.yoga.User.model.QCompanyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
public class CustomRepository {
    @Autowired
    private EntityManager entityManager;

    public long updateCompanyUser(CompanyUser companyUser) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QCompanyUser qCompanyUser = QCompanyUser.companyUser;
        return jpaQueryFactory.update(qCompanyUser)
                .where(qCompanyUser.userId.eq(companyUser.getUserId()))
                .set(qCompanyUser.lastName, companyUser.getLastName())
                .execute();
    }
}
