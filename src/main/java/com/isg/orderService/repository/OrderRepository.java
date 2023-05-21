package com.isg.orderService.repository;

import com.isg.orderService.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends MongoRepository<Order, String>, QuerydslPredicateExecutor<Order> {
    List<Order> findByCustomer(String id);
}
