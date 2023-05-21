package com.isg.UserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
   
	@Id
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
