package com.piner.order_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.piner.order_service.domain.ProductOrder;
import com.piner.order_service.service.ProductClientService;
import com.piner.order_service.service.ProductOrderservice;
import com.piner.order_service.utile.JsonUtiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Date;
import java.util.UUID;


@Service
public class ProductOrderServiceImpl implements ProductOrderservice{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private ProductClientService productClientService;
    //获取商品详情
    @Override
    public ProductOrder save(int userId, int productId) {

        /*
        rebbon服务调用方式

        Map<String,Object> productMap = restTemplate.getForObject("http://product-server/api/v1/product/find?id="+productId,Map.class);
        System.out.println(productMap);
        */

        /*
        feign服务调用方式，调用订单服务
         */
        String response = productClientService.findById(productId);
        logger.info("service save order");
        JsonNode jsonNode = JsonUtiles.strJsonNode(response);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setSerialNumber(UUID.randomUUID().toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        return productOrder;
    }
}
