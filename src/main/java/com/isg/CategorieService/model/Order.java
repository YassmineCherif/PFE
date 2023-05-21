package com.isg.CategorieService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Order implements Serializable {
   
	@org.springframework.data.annotation.Id
	private String id;
	@NotNull
	private Date orderDate;
	@NotNull
	private String customer;
	@NotNull
	private String state;
	private double amount;
	
	@NotEmpty
	private List<OrderDetail> details;

	
	
	
}
