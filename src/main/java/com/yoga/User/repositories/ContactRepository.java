package com.yoga.User.repositories;

import com.yoga.User.model.Contact;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository  extends QuerydslPredicateExecutor<Contact>, CrudRepository<Contact, Long> {
}
