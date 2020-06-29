package com.yoga.User.repositories;

import com.yoga.User.model.Role;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends QuerydslPredicateExecutor<Role>, CrudRepository<Role,Long> {
}
