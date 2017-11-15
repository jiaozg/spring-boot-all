package com.example.demo.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.domain.City;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0", loadbalance="roundrobin")
    CityDubboService cityDubboService;

    public City printCity() {
        String cityName="温岭";
        City city = cityDubboService.findCityByName(cityName);
        return city;
    }
}
