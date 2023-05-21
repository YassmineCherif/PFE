package com.isg.UserService.repository;


import com.isg.UserService.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
	
	Admin findOneByRole(String role);
	List<Admin> findByRole(String role);
	Admin findByMailAndPassword(String mail,String password);

}
