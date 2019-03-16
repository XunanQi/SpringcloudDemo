package net.xdclass.order_service.service;


import net.xdclass.order_service.domain.Order;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author Ian
 * @Description: 订单
 * @Date 2019/3/13
 */
public interface OrderService {

    Order save(int userId,int productId);

}
