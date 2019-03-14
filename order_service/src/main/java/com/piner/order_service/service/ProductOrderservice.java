package com.piner.order_service.service;

import com.piner.order_service.domain.ProductOrder;
/*
    订单业务
 */
public interface ProductOrderservice {
    /*
        下单接口
     */
    ProductOrder save(int userId,int productId);
}
