package com.isg.ProductService.repository;


import com.isg.ProductService.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String>, QuerydslPredicateExecutor<Review> {

	
	List<Review> findByProduct(String id);
	List<Review> findByCustomer(String id);

}
