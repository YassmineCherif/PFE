package com.isg.UserService.repository;

import com.isg.UserService.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
   Customer findByMailAndPassword(String mail,String password);
}

