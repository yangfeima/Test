package com.nacos.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX0011159
 * @title TestService
 * @date 2020/4/16
 * @since <版本号>
 */
@FeignClient(name = "nacos-provider")
public interface TestService {

    /**
     * 调用生产者方法
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
    public String order();
}
