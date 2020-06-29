package com.yoga.User.repositories;

import com.yoga.User.model.Company;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends QuerydslPredicateExecutor<Company>, CrudRepository<Company, Long> {
}
