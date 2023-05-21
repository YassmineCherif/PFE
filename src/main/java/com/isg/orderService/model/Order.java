package com.isg.orderService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
//
    private Date orderDate;

    private String customer;


    private String state;
    private double amount;


    private List<OrderDetail> details;
}
