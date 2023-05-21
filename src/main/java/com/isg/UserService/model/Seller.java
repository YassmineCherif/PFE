package com.isg.UserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Seller extends User implements Serializable {
	
	@Id
	private String id;
	private String companyName;
	private String address;
	private List<Product> products;
	


	
	
}
