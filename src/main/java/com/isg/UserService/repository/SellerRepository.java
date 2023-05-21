package com.isg.UserService.repository;

import com.isg.UserService.model.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends MongoRepository<Seller, String> {
  Seller  findByMailAndPassword(String mail,String password);
}
