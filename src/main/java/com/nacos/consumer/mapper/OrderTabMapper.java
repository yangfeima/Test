package com.nacos.consumer.mapper;


import com.nacos.consumer.model.OrderTab;
import org.apache.ibatis.annotations.Mapper;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX0011159
 * @title OrderTabMapper
 * @date 2020/4/16
 * @since <版本号>
 */
@Mapper
public interface OrderTabMapper {

	/**
	 * <方法描述>
	 *
	 * @param  [order] 
	 * @return void
	 * @title  addOrderTab
	 * @tables <涉及表说明，便于调用方调试>
	 * @special <特殊说明>
	 * @author HX0011159
	 * @date 2020/4/16
	 * @since <版本号>
	 */
	 public void addOrderTab(OrderTab order);



}
