package com.nacos.consumer.service;

import com.nacos.consumer.mapper.OrderTabMapper;
import com.nacos.consumer.model.OrderTab;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单接口实现类
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
@Service
public class OrderTabServiceImpl implements OrderTabService {

    @Resource
    private OrderTabMapper orderTabMapper;

    @Resource
    private TestService testService;
    /**
     * 添加订单实现
     * @author  HX0011159
     * @description  添加订单实现
     * @return  void
     * @date  2020/4/20
     */
    @Override
    @GlobalTransactional
    public void insertOrderTab(){
        String orderId = System.currentTimeMillis() + "";
        OrderTab order = new OrderTab();
        order.setOrderId(orderId);
        order.setStatus(1);
        orderTabMapper.insert(order);

        System.out.println(RootContext.getXID());
        // 调用生产者
        String orderIdPro = System.currentTimeMillis() + "";
        OrderTab orderPro = new OrderTab();
        orderPro.setOrderId(orderIdPro);
        orderPro.setStatus(1);
        testService.insertOrder(order);
    }
}
