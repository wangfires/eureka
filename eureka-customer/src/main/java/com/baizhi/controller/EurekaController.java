package com.baizhi.controller;

import com.baizhi.entity.Cart;
import com.baizhi.entity.ProductInfo;
import com.baizhi.entity.User;
import com.baizhi.feign.FeignProduct;
import com.baizhi.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("product")
public class EurekaController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FeignProduct feignProduct;
    @Autowired
    private OrderDetailService orderDetailService;
//    @Autowired
//    private RestTemplate restTemplate;
////    @Autowired
////    private LoadBalancerClient loadBalancerClient;
//    @RequestMapping("test1")
//    public Object aa(String name){
//         //第一种RestTemplate调用方式
////        RestTemplate restTemplate = new RestTemplate();
////        String forObject = restTemplate.getForObject("http://localhost:8999/aa/aa?name=" + name, String.class);
//         //第二种RestTemplate调用方式 LoadBalancerClient 获取IP PORT
////        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
////        RestTemplate restTemplate = new RestTemplate();
////        System.out.println(instance.getHost() + ":" + instance.getPort() + "/hello/hello?name=" + name);
////        String forObject = restTemplate.getForObject("http://"+instance.getHost() + ":" + instance.getPort() + "/aa/aa?name=" + name, String.class);
//        // 第三种RestTemplate调用方式 通过实例名 获取对应的实例服务ip port
//        Object forObject = restTemplate.getForObject("http://eureka-client/product/list", Object.class);
//        return forObject;
//    }
    @RequestMapping("list")
    public Map<String,Object> aa(){
        Map<String, Object> map = feignProduct.aa();
        return map;
    }
    @RequestMapping("add1")
    public ProductInfo bb(String id){
        ProductInfo p = feignProduct.bb(id);
        Map<String, Cart> cart = (Map<String, Cart>) request.getSession().getAttribute("cart");
        Cart cart1 = new Cart(p.getProductId(),p.getProductName(),1,p.getProductPrice(),p.getProductPrice(),p.getProductIcon(),p.getCreateTime(),p.getCreateTime());
        HashMap<String, Cart> map = new HashMap<>();
        if(cart==null){
            System.out.println(cart);
            map.put(p.getProductId(),cart1);
            request.getSession().setAttribute("cart",map);

        } else {
            if (cart.containsKey(id)){
                cart.get(id).setCount(cart.get(id).getCount()+1);
                cart.get(id).setTotal(cart.get(id).getPrice()*cart.get(id).getCount());

            }else {
                cart.put(id,cart1);
//                request.getSession().setAttribute("c");
            }
            User user = new User("1","ww","123456","云南","123456");
            request.getSession().setAttribute("cart",cart);
            request.getSession().setAttribute("login",user);
        }
        return p;
    }
}
