package com.isg.UserService.config;

import com.isg.UserService.model.Order;
import com.isg.UserService.model.Product;
import com.isg.UserService.model.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product-service", url = "product:8071")
public interface ProductResourceFeign {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    List<Product> getBySeller(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    List<Review> getReviwesByCustomer(@PathVariable("id") String id);
}
