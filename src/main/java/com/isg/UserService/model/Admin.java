package com.isg.UserService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User implements Serializable {
	
	@Id
	private String id;
	private String role;
	private String address;
	


	
	
}
