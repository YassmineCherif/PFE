package com.isg.CategorieService.repository;


import com.isg.CategorieService.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepoitory extends MongoRepository<Category, String>, QuerydslPredicateExecutor<Category> {
    Long countByInHome(boolean inHome);
    List<Category> findByInHome(boolean inHome);
}
