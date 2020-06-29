package com.yoga.User.repositories;

import com.yoga.User.model.CompanyUser;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyUserRepository extends QuerydslPredicateExecutor<CompanyUser>,
        CrudRepository<CompanyUser,Long> {


}
