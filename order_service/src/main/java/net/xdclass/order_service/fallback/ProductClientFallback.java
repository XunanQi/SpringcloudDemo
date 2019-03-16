package net.xdclass.order_service.fallback;

import net.xdclass.order_service.service.ProductClient;
import org.springframework.stereotype.Component;

/**
 * @Author Ian
 * @Description: 针对商品服务做降级
 * @Date 2019/3/16
 */
@Component
public class ProductClientFallback implements ProductClient {

    @Override
    public String findById(int id) {

        System.out.println("服务器出错 调用出错");
        return null;
    }





}
