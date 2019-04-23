package com.baizhi.controller;

import com.baizhi.entity.*;
import com.baizhi.service.CategoryService;
import com.baizhi.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
public class productController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("list")
    public Map<String,Object> aa(){
        Map<String, Object> result = new HashMap<>();
        ArrayList<Food> food11 = new ArrayList<>();
        ArrayList<Food> food22 = new ArrayList<>();
        ArrayList<Dat> datlist = new ArrayList<>();
        try {
            ProductCategory productCategory1 = categoryService.findByType(11);
            ProductCategory productCategory2 = categoryService.findByType(22);
            List<ProductInfo> productInfo11 = productInfoService.findByType(11);
            System.out.println(productInfo11);
            List<ProductInfo> productInfo22 = productInfoService.findByType(22);
            for (ProductInfo productInfo : productInfo11) {
                Food food = new Food();
                food.setId(productInfo.getProductId());
                food.setName(productInfo.getProductName());
                food.setPrice(productInfo.getProductPrice());
                food.setDescription(productInfo.getProductDescription());
                food.setIcon(productInfo.getProductIcon());
                food11.add(food);
            }
            for (ProductInfo productInfo : productInfo22) {
                Food food = new Food();
                food.setId(productInfo.getProductId());
                food.setName(productInfo.getProductName());
                food.setPrice(productInfo.getProductPrice());
                food.setDescription(productInfo.getProductDescription());
                food.setIcon(productInfo.getProductIcon());
                food22.add(food);
            }
            Dat dat = new Dat();
            Dat dat1 = new Dat();
            dat.setName(productCategory1.getCategoryName());
            dat.setType("11");
            dat.setFoods(food11);
            dat1.setName(productCategory2.getCategoryName());
            dat1.setType("22");
            dat1.setFoods(food22);
            datlist.add(dat);
            datlist.add(dat1);
            result.put("code",0);
            result.put("msg","成功");
            result.put("data",datlist);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("code",1);
            result.put("msg","失败");
            result.put("data",datlist);
            return result;
        }
    }
    @RequestMapping("add")
    public Map<String, Integer> bb(@RequestParam("id")String id,HttpServletRequest request){
        ProductInfo productInfo = productInfoService.findOne(id);
        Map<String, Integer> map= (Map<String, Integer>) request.getSession().getAttribute("cart");

        if (map==null){
            HashMap<String, Integer> cartmap = new HashMap<>();
            cartmap.put(productInfo.getProductId(),1);
            request.getSession().setAttribute("cart",cartmap);
            System.out.println(cartmap);
            return cartmap;
        }else{
            for (String s : map.keySet()) {
                if (id.equals(s)) {
                    map.put(id, map.get(id) + 1);
                } else {
                    map.put(productInfo.getProductId(), 1);
                }
            }
        }
        request.getSession().setAttribute("cart",map);
        System.out.println(map);
        return map;
    }
    @RequestMapping("add1")
    @Validated
    public ProductInfo findcart(@RequestParam("id") String id){
        ProductInfo productInfo = productInfoService.findOne(id);

        return productInfo;

//        Cart cart = new Cart();
//        cart.setId(productInfo.getProductId());
//        cart.setName(productInfo.getProductName());
//        cart.setPrice(productInfo.getProductPrice());
//        cart.setCount(1);
//        cart.setTotal(cart.getPrice()*cart.getCount());
//        ArrayList<Cart> cartlist = (ArrayList<Cart>) request.getSession().getAttribute("cart");
//        cart.setId(productInfo.getProductId());
//        cart.setName(productInfo.getProductName());
//        cart.setPrice(productInfo.getProductPrice());
//        cart.setCount(1);
//        cart.setTotal(cart.getPrice()*cart.getCount());
//        if (cartlist==null){
//            ArrayList<Cart> carts = new ArrayList<>();
//            carts.add(cart);
//            request.getSession().setAttribute("cart",carts);
//            return carts;
//        }else {
//            for (Cart cart1 : cartlist) {
//                if (id.equals(cart1.getId())){
//                    cart1.setCount(cart1.getCount()+1);
//                }else {
//                    cartlist.add(cart);
//                }
//            }
//        }
//        request.getSession().setAttribute("cart",cartlist);



    }
    @RequestMapping("update")
    public void cc(String id){
        productInfoService.update(id);




    }
}
