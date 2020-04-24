package com.nacos.consumer.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单实体类
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
@Setter
@Getter
public class OrderTab {

    private int id;
    private String orderId;
    /**
     * 0:未处理，1：成功  2：失败
     */
    private int status;
    private String createTime;
}
