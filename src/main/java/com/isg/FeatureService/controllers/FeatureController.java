package com.isg.FeatureService.controllers;


import com.isg.FeatureService.model.*;
import com.isg.FeatureService.repository.FeatureRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin("*")
@RestController
@RequestMapping("/feature-service/")
@RequiredArgsConstructor
public class FeatureController {

	private FeatureRepository featureRepository;
	
	/*
	* Method for adding new features to a product 
	*/
	@PostMapping("/addFeatures")
	public List<Feature> addFeatures(@Valid @RequestBody List<Feature> features, @RequestParam String id){
		for(int i=0;i<features.size();i++) {
			features.get(i).setProduct(id);
		}
		return featureRepository.saveAll(features);
		
	}
	/*
	* Method for updating a  feature 
	*/
	@PostMapping("/saveFeature")
	public Feature saveFeature(@Valid @RequestBody Feature feature){
		return featureRepository.save(feature);
		
	}
	/*
	* Method for retrieving the list of features by product id 
	*/
	@GetMapping("/ByProduct/{id}")
	public List<Feature> getByProduct(@PathVariable("id") String id) {
		return   this.featureRepository.findByProduct(id);
	}	
	@GetMapping("/deleteByProduct/{id}")
	public void deleteByProduct(@PathVariable("id") String id) {
		List<Feature> features =   this.featureRepository.findByProduct(id);
		featureRepository.deleteAll(features);
		

	}
	/*
	* Method for retrieving all the features
	*/
	@RequestMapping("/allFeatures")
	public List<Feature> getFeatures(){
		return featureRepository.findAll();
	}
	/*
	* Method for getting products that have features filtered by keyword
	*/
	@RequestMapping("/featuresByKeyword/{keyword}")
	public List<String> filterByDescription(@PathVariable("keyword") String keyWord){
		QFeature qFeature = new QFeature("feature");
		
		BooleanExpression filterByKeyWord = qFeature.value.containsIgnoreCase(keyWord);
		List<Feature> features =(List<Feature>) featureRepository.findAll(filterByKeyWord);
		List<String> ids = features.stream().map(Feature::getProduct).collect(Collectors.toList());

		return ids ;
	}
	
}
