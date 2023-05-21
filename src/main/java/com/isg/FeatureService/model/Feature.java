package com.isg.FeatureService.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Feature {
	@Id
	private String id;
	@NotNull
	private String name;
	@NotNull
	private String value;
	private String product;

	
}
