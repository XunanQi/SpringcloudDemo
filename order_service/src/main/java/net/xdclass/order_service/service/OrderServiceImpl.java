package net.xdclass.order_service.service;

import com.fasterxml.jackson.databind.JsonNode;
import net.xdclass.order_service.domain.Order;
import net.xdclass.order_service.utils.jsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Ian
 * @Description:
 * @Date 2019/3/13
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProductClient productClient;

    @Override
    public Order save(int userId, int productId) {
        //获取商品详情
      //  Map<String,Object> productMap
        // Map<String,Object> productMap = restTemplate.getForObject("http://product-service/api/v1/product/findById?id="+productId,Map.class);
        /*ServiceInstance instance = loadBalancerClient.choose("product-service");
        instance.get*/
        String response = productClient.findById(productId);
        JsonNode jsonNode = jsonUtils.str2JsonNode(response);

        Order order = new Order();
        order.setCreateTime(new Date());
        order.setUserId(userId);
        order.setTradeNo(UUID.randomUUID().toString());
        order.setProductName(jsonNode.get("name").toString());
        order.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        return order;
    }
}
