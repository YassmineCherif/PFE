package com.isg.CategorieService.repository;


import com.isg.CategorieService.model.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {
	List<SubCategory> findByCategory(String id);
	void deleteByCategory(String id);
}
