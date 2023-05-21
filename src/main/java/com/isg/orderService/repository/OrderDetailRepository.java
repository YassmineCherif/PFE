package com.isg.orderService.repository;

import com.isg.orderService.model.OrderDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends MongoRepository<OrderDetail, String> {
	
	List<OrderDetail> findByOrder(String id);
	Long countByOrderAndState(String id,String state);
	List<OrderDetail> findBySeller(String id);
	List<OrderDetail> findBySellerAndOrder(String seller,String order);

}
