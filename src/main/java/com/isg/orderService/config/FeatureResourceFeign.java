package com.isg.orderService.config;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "feature-service")
public interface FeatureResourceFeign {

}
