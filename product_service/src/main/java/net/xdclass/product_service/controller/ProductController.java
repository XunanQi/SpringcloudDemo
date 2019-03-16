package net.xdclass.product_service.controller;

import net.xdclass.product_service.domain.Product;
import net.xdclass.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Ian
 * @Description:产品类
 * @Date 2019/3/13
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;
    /**
     * 获取所有商品列表
     * @return
     */
    @RequestMapping("list")
    public List<Product> lsit(){
        return productService.listProduct();
    }

    /**
     * 根据id查商品
     * @return
     */
    @RequestMapping("findById")
    public Product findById(@RequestParam("id") int id){
        int i=1/0;
        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName(result.getName()+" datr from port="+port);
        return result;
    }



}



