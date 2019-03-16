package net.xdclass.product_service.service;

import net.xdclass.product_service.domain.Product;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.*;

/**
 * @Author Ian
 * @Description:
 * @Date 2019/3/13
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static Map<Integer,Product> daoMap=new HashMap<>();
    static {
        Product p1 = new Product(1,"iphone4",1000,1);
        Product p2 = new Product(2,"iphone5",2000,2);
        Product p3 = new Product(3,"iphone6",3000,3);
        Product p4 = new Product(4,"iphone7",4000,4);
        Product p5 = new Product(5,"iphone8",5000,5);
        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);
    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection=daoMap.values();
        List<Product> list=new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product findById(int id) {
        return daoMap.get(id);
    }
}
