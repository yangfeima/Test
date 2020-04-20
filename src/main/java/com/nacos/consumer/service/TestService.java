package com.nacos.consumer.service;

import com.nacos.consumer.model.OrderTab;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign订单调用类
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
@FeignClient(name = "nacos-provider")
public interface TestService {

    /**
     * 调用订单
     * @author  HX0011159
     * @description  调用订单
     * @param  orderTab 订单实体参数
     * @return  java.lang.String
     * @date  2020/4/20
     */
    @GetMapping("/addOrder")
    void addOrder(OrderTab orderTab);
}
