package com.isg.CategorieService.config;

import com.isg.CategorieService.model.Product;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductResourceFeign {
    @GetMapping("/ByCategory/{id}")
    List<Product> getByCategory(@PathVariable("id") String id);

    @GetMapping("/ByCategory/{id}/{page}/{sort}/{dir}")
    List<Product> getByCategory(@PathVariable("id") String id,@PathVariable("page") int page,@PathVariable("sort") String sort,@PathVariable("dir") String dir);

    @GetMapping("/filterByKeywordCatIds/{keyWord}")
    List<String> filter(@PathVariable("keyWord") String keyWord);

    @GetMapping("/filterByKeywordCat/{keyWord}/{category}/{page}")
    Page<Product> filterBykeyWordAndPageAndCategory(@PathVariable("keyWord") String keyWord,@PathVariable("category") String category,@PathVariable("page") int page);

    @GetMapping("/BySubCategory/{id}")
    public List<Product> getBySubCategory(@PathVariable("id") String id);

    @GetMapping("/BySubCategory/{id}/{page}/{sort}/{dir}")
    public Page<Product> getBySubCategoryByPage(@PathVariable("id") String id,@PathVariable("page") int page,@PathVariable("sort") String sort,@PathVariable("dir") String dir);

}
