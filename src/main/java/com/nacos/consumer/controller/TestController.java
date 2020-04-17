package com.nacos.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.consumer.service.OrderTabService;
import com.nacos.consumer.service.TestService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单访问类
 * <功能详细描述>
 *
 * @author HX0011159
 * @title TestController
 * @date 2020/4/16
 * @since <版本号>
 */
@Slf4j
@RestController
@RefreshScope
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderTabService orderTabService;

    @Autowired
    private TestService testService;

    /**
     * <方法描述>
     *
     * @param
     * @return java.lang.String
     * @title  test1
     * @tables <涉及表说明，便于调用方调试>
     * @special <特殊说明>
     * @author HX0011159
     * @date 2020/4/16
     * @since <版本号>
     */
    @SentinelResource("test1")
    @GetMapping("/test1")
    public String test1() {
        String url = "http://nacos-provider/order";
        String str =  restTemplate.getForObject(url, String.class);
        return "success";
    }

    /**
     * nacos分布式事务
     *
     * @param
     * @return java.lang.String
     * @title  order
     * @tables <涉及表说明，便于调用方调试>
     * @special <特殊说明>
     * @author HX0011159
     * @date 2020/4/16
     * @since <版本号>
     */
    @GetMapping("/order")
    @GlobalTransactional
    public String order() {
        //
        orderTabService.addOrderTab();
        System.out.println(RootContext.getXID());
        testService.order();
        return "success";
    }
}
