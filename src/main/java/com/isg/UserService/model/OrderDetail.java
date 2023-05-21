package com.isg.UserService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {
   
	@Id
	private String id;
	private String order;
	@NotNull
	private String product;
	@NotNull
	private String seller;
	@NotNull
	private int quantity;
	@NotNull
	private double suggestedPrice;
	@NotNull
	private double approvedPrice;
	@NotNull
	private String state;

    	
	
	
	
	
	
}
