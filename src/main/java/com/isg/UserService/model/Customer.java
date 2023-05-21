package com.isg.UserService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User implements Serializable {
	
	@Id
	private String id;
	private String gender;
	private String address;
	private String deliveryAddress;
	private List<Review> reviews;
	

	
}
