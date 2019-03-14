package com.piner.order_service.fallbcak;

import com.piner.order_service.service.ProductClientService;
import org.springframework.stereotype.Component;
/*
    针对商品服务做降级处理
 */
@Component
public class ProductClientFallback implements ProductClientService{


    @Override
    public String findById(int id) {
        System.out.println("异常降级处理");
        return null;
    }


}
