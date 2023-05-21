package com.isg.ProductService.repository;


import com.isg.ProductService.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {

	
	List<Image> findByProduct(String id);
	void deleteByProduct(String id);
}
