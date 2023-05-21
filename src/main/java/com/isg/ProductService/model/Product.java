package com.isg.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	@Id
	private String id;
	@NotNull
	private String designation;
	@NotNull
	private String description;
	@NotNull
	private int quantity;
	@NotNull
	private double price;
	/* @NotNull */
	private List<Object> priceHistory;
	@NotNull
	private boolean inHome;
	@NotNull
	private String seller;
	@NotNull
	private String subCategory;
	@NotNull
	private String category;
	@NotNull
	private boolean deleted;
	
	private List<Feature> features;
	
	private List<Image> images;
	
	private List<Review> reviews;



}
