package com.isg.CategorieService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {
	
	@Id
	private String id;
	@NotNull
	private String name;
	@NotNull
	private String path;
	@NotNull
	private String product;
	


}
