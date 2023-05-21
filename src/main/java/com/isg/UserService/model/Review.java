package com.isg.UserService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review implements Serializable {
	@Id
	private String id;
	@NotNull
	private String customer;
	@NotNull
	private String product;
	@NotNull
	private String comment;
	@NotNull
	private int note;
	@NotNull
	private Date reviewDate;
	
	


}
