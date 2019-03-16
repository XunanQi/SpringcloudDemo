package net.xdclass.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.xdclass.order_service.domain.Order;
import net.xdclass.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author Ian
 * @Description:产品类
 * @Date 2019/3/13
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id")int userId,
                       @RequestParam("product_id")int productId){
    Map<String,Object>  map = new HashMap<>();
    Order order=orderService.save(userId,productId);
    map.put("code","0");
    map.put("code",order);
    return map;
    }

    public Object saveOrderFail(int userId,int productId){
        Map<String,Object>  map = new HashMap<>();
        map.put("code","1");
        map.put("msy","服务器出错");
        return map;
    }


}



