package com.baizhi.conf;

import com.baizhi.entity.ProductInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(serviceId = "eureka")
public interface fignPost {
    @RequestMapping(value = "/test/test1", method = RequestMethod.POST)
    public ProductInfo sayHi(ProductInfo productInfo);
}
