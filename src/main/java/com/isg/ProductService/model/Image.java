package com.isg.ProductService.model;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import javax.persistence.*;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
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
