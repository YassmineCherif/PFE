package com.isg.FeatureService.repository;


import com.isg.FeatureService.model.Feature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepository extends MongoRepository<Feature, String>, QuerydslPredicateExecutor<Feature> {
	
	public List<Feature> findByProduct(String id);

}
