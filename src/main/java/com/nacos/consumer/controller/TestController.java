package com.nacos.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.consumer.service.OrderTabService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * 订单类
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
@Slf4j
@RestController
@RefreshScope
@Api(value = "订单类")
public class TestController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private OrderTabService orderTabService;

    /**
     *　测试调用生产者接口
     * @author  HX0011159
     * @description  测试调用生产者接口
     * @return  java.lang.String
     * @date  2020/4/20
     */
    @SentinelResource("test1")
    @GetMapping("/test1")
    @ApiOperation(value = "调用生产者接口",notes = "调用生产者接口")
    public String test1() {
        String url = "http://nacos-provider/findAllOrder";
        restTemplate.getForObject(url, String.class);
        return "success";
    }

    /**
     *　分布式事务调用测试
     * @author  HX0011159
     * @description  分布式事务调用测试
     * @return  java.lang.String
     * @date  2020/4/20
     */
    @GetMapping("/order")
    @ApiOperation(value = "分布式事务操作",notes = "分布式事务操作")
    public String order() {
        orderTabService.addOrderTab();
        return "success";
    }
}
