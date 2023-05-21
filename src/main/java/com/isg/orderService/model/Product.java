package com.isg.orderService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String designation;
    private String description;
    private int quantity;
    private double price;
    private List<Object> priceHistory;

    private boolean inHome;

    private String seller;

    private String subCategory;

    private String category;

    private boolean deleted;





}
