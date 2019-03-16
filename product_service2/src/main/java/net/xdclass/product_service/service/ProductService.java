package net.xdclass.product_service.service;

import net.xdclass.product_service.domain.Product;

import java.util.List;

/**
 * @Author Ian
 * @Description: 商品业务层
 * @Date 2019/3/13
 */
public interface ProductService {
    List<Product> listProduct();
    Product findById(int id);
}
