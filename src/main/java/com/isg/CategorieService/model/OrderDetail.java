package com.isg.CategorieService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
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
