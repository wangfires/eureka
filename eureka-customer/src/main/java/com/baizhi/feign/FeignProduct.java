package com.baizhi.feign;

import com.baizhi.entity.ProductInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(serviceId = "eureka-client")
public interface FeignProduct {
    @RequestMapping(value = "/product/list",method = RequestMethod.POST)
    public Map<String,Object> aa();
    @RequestMapping(value = "/product/add1",method = RequestMethod.POST)
    public ProductInfo bb(@RequestParam("id") String id);
    @RequestMapping(value = "/product/update",method = RequestMethod.POST)
    public void cc(String id);
}
