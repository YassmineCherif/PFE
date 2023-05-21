package com.isg.ProductService.config;

import com.isg.ProductService.model.Feature;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "feature-service",url = "http://localhost:8086/")
public interface FeatureResourceFeign {
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    Feature addFeatures(@Valid @RequestBody List<Feature> features, @RequestParam String id);

    @PostMapping("addFeatures")
    List<String> filterByDescription(@PathVariable("keyword") String keyWord);
    @GetMapping("getByProduct/{id}")
    List<Feature>  getByProduct(@PathVariable("id") String id);
    @DeleteMapping("deleteByProduct/{id}")
    Feature  deleteByProduct(@PathVariable("id") String id);

}
