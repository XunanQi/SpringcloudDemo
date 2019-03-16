package net.xdclass.order_service.service;

import net.xdclass.order_service.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Ian
 * @Description:商品服务客户端
 * @Date 2019/3/14
 */
@FeignClient(name="product-service",fallback = ProductClientFallback.class)
public interface ProductClient {

    @GetMapping("/api/v1/product/findById")
    String findById(@RequestParam(value = "id") int id);


}
