package com.isg.orderService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String order;
    private String product;
    private String seller;
    private int quantity;
    private double suggestedPrice;
    private double approvedPrice;
    private String state;




}
