package com.nacos.consumer.mapper;


import com.nacos.consumer.model.OrderTab;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单类Mapper
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
@Mapper
public interface OrderTabMapper {

	  /**
	   * 添加订单
	   * @author  HX0011159
	   * @description  
	   * @param  order OrderTab对象
	   * @return  void
	   * @date  2020/4/20
	   */
	  void addOrderTab(OrderTab order);
}
