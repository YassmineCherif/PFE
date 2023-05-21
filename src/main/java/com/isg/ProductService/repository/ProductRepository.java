package com.isg.ProductService.repository;


import com.isg.ProductService.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>, QuerydslPredicateExecutor<Product> {

	
	List<Product> findBySubCategory(String id);
	List<Product> findBySubCategoryAndDeleted(String id,boolean deleted);
	Page<Product> findBySubCategory(String id, Pageable page);
	Page<Product> findBySubCategoryAndDeleted(String id, Pageable page, boolean deleted);
	List<Product> findByCategory(String id);
	List<Product> findByCategoryAndDeleted(String id,boolean deleted);
	Page<Product> findByCategory(String id, Pageable page);
	Page<Product> findByCategoryAndDeleted(String id, Pageable page, boolean deleted);
	List<Product> findBySeller(String id);
	List<Product> findBySellerAndDeleted(String id,boolean deleted);
	Page<Product> findBySeller(String id, Pageable page);
	Page<Product> findBySellerAndDeleted(String id, Pageable page, boolean deleted);
	Long countByInHome(boolean inHome);
    List<Product> findByInHome(boolean inHome);
	Long countByInHomeAndDeleted(boolean inHome,boolean deleted);
    List<Product> findByInHomeAndDeleted(boolean inHome,boolean deleted);
    Long countByDeleted(boolean deleted);
}
