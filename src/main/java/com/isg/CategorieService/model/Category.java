package com.isg.CategorieService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private boolean inHome;
    private List<SubCategory> subCategories;
    private List<Product> products;
    private Object productsPage;


}
