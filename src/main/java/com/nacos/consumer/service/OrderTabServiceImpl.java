package com.nacos.consumer.service;

import com.nacos.consumer.mapper.OrderTabMapper;
import com.nacos.consumer.model.OrderTab;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 添加订单接口实现类
 * <功能详细描述>
 *
 * @author HX0011159
 * @title OrderTabServiceImpl
 * @date 2020/4/16
 * @since <版本号>
 */
@Service
public class OrderTabServiceImpl implements OrderTabService {

    @Resource
    private OrderTabMapper orderTabMapper;

    /**
     * 添加订单
     *
     * @param
     * @return void
     * @title  addOrderTab
     * @tables <涉及表说明，便于调用方调试>
     * @special <特殊说明>
     * @author HX0011159
     * @date 2020/4/16
     * @since <版本号>
     */
    @Override
    public void addOrderTab(){
        String orderId = System.currentTimeMillis() + "";
        OrderTab order = new OrderTab();
        order.setOrderId(orderId);
        order.setStatus(1);
        orderTabMapper.addOrderTab(order);
    }
}
